package in.careerscale.apps.ocms.service;

import in.careerscale.apps.ocms.dao.UserRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import in.careerscale.apps.ocms.dao.model.LoginMaster;
import in.careerscale.apps.ocms.mail.EmailSender;
import in.careerscale.apps.ocms.mail.EmailTemplates;
import in.careerscale.apps.ocms.mail.Template;
import in.careerscale.apps.ocms.service.exception.ApplicationException;
import in.careerscale.apps.ocms.web.registration.model.User;
import in.careerscale.apps.ocms.dao.model.UserRole;

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmailSender emailService;

	@PostConstruct
	protected void initialize() {
		// userRepository.save(new User("user", "demo", "ROLE_USER"));
		// userRepository.save(new User("admin", "admin", "ROLE_ADMIN"));
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		LoginMaster user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
																				// proper
																				// rle
		Iterator<UserRole> it = user.getUserRoles().iterator();
		UserRole userRole = null;
		Set<GrantedAuthority> roleSet = new HashSet<GrantedAuthority>();
		while (it.hasNext())
		{
			userRole = it.next();
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole.getRoleMaster().getRoleName());
			roleSet.add(grantedAuthority);
		}

		return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), roleSet);	}

	public void registerUser(User user) throws ApplicationException {
		// for bravity no validations done at service layer, we need to handle
		// and also introduce valid exception handling to manage error
		// situations
		try {
			userRepository.registerUser(new LoginMaster(user.getEmailId(), user
					.getPassword(), user.getFirstName(), user.getLastName(),
					user.getDateOfBirth()));
			try{
			// Resolve variables
			Map<String, String> placeHolderValues = new HashMap<String, String>();
			placeHolderValues.put(EmailTemplates.firstName, user.getFirstName());
			placeHolderValues.put(EmailTemplates.userName, user.getEmailId());
			placeHolderValues.put(EmailTemplates.password, user.getPassword());
			String emailText = EmailTemplates.getEmailMessage(
					Template.Registration, placeHolderValues);
			emailService.sendMailWithSSL("Registration",emailText, user.getEmailId());
			}catch(Exception mailFailure){
				mailFailure.printStackTrace();
				//TODO this is just stupid to print stacktrace. log it buddy.
			}
		} catch (PersistenceException pe) {
			throw new ApplicationException(pe.getMessage());
		}

	}

	public User findByUsername(String username) {

		LoginMaster loginMaster = userRepository.findByUsername(username);

		if (loginMaster != null) {
			return new User(loginMaster.getEmailId(),
					loginMaster.getFirstName(), loginMaster.getLastName(),
					loginMaster.getDateOfBirth());
		} else {
			return null;
		}
	}
}