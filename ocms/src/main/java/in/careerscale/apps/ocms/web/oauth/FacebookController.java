package in.careerscale.apps.ocms.web.oauth;


import static org.springframework.web.context.request.RequestAttributes.SCOPE_SESSION;

import javax.servlet.http.HttpServletRequest;

import in.careerscale.apps.ocms.integration.oauth.OAuthServiceProvider;
import in.careerscale.apps.ocms.service.UserService;
import in.careerscale.apps.ocms.service.exception.ApplicationException;
import in.careerscale.apps.ocms.web.oauth.util.OAUthParser;
import in.careerscale.apps.ocms.web.registration.model.User;

import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;


import static in.careerscale.apps.ocms.web.oauth.SessionAttributes.*;

@Controller
public class FacebookController {
	
	@Autowired
	@Qualifier("facebookServiceProvider")
	private OAuthServiceProvider facebookServiceProvider;
	
	private static final Token EMPTY_TOKEN = null;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/login-facebook"}, method = RequestMethod.GET)
	public String login(WebRequest request) {
		
		// getting request and access token from session
		Token accessToken = (Token) request.getAttribute(ATTR_OAUTH_ACCESS_TOKEN, SCOPE_SESSION);
		if(accessToken == null) {
			// generate new request token
			OAuthService service = facebookServiceProvider.getService();
			request.setAttribute(ATTR_OAUTH_REQUEST_TOKEN, EMPTY_TOKEN, SCOPE_SESSION);
			
			// redirect to facebook auth page
			return "redirect:" + service.getAuthorizationUrl(EMPTY_TOKEN);
		}
		//TODO
		//Get user information and update spring security context for the user. 
		//Since we are trusting thirdparty oauth providers 
		return "home/index";
	}
	
	@RequestMapping(value={"/facebook-callback"}, method = RequestMethod.GET)
	public String callback(@RequestParam(value="code", required=false) String oauthVerifier, WebRequest request,HttpServletRequest req) {
		
		// getting request token
		OAuthService service = facebookServiceProvider.getService();
		Token requestToken = (Token) request.getAttribute(ATTR_OAUTH_REQUEST_TOKEN, SCOPE_SESSION);
		
		// getting access token
		Verifier verifier = new Verifier(oauthVerifier);
		Token accessToken = service.getAccessToken(requestToken, verifier);
		
		// store access token as a session attribute
		request.setAttribute(ATTR_OAUTH_ACCESS_TOKEN, accessToken, SCOPE_SESSION);
		
		// getting user profile
		OAuthRequest oauthRequest = new OAuthRequest(Verb.GET, "https://graph.facebook.com/me");
		service.signRequest(accessToken, oauthRequest);
		Response oauthResponse = oauthRequest.send();
		System.out.println(oauthResponse.getBody());

		request.setAttribute("oAuthResponse", oauthResponse.getBody(), 0);
			
		User user = OAUthParser.getUserFromFacebookUserProfile(oauthResponse.getBody());

		try {
			userService.registerUser(user);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "oauth/oauthprofile";

	}
}