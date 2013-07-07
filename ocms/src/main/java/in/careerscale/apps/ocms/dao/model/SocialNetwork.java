package in.careerscale.apps.ocms.dao.model;

// Generated Jul 7, 2013 10:49:55 AM by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SocialNetwork generated by hbm2java
 */
@Entity
@Table(name = "social_network", catalog = "ocms")
public class SocialNetwork implements java.io.Serializable {

	private Integer id;
	private String name;
	private String description;
	private String apiKey;
	private String apiSecret;
	private String callbackUrl;
	private String scope;
	private Set userNetworks = new HashSet(0);

	public SocialNetwork() {
	}

	public SocialNetwork(String name, String description, String apiKey,
			String apiSecret, String callbackUrl, String scope, Set userNetworks) {
		this.name = name;
		this.description = description;
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.callbackUrl = callbackUrl;
		this.scope = scope;
		this.userNetworks = userNetworks;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", length = 250)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "api_key", length = 45)
	public String getApiKey() {
		return this.apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	@Column(name = "api_secret", length = 45)
	public String getApiSecret() {
		return this.apiSecret;
	}

	public void setApiSecret(String apiSecret) {
		this.apiSecret = apiSecret;
	}

	@Column(name = "callback_url", length = 100)
	public String getCallbackUrl() {
		return this.callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	@Column(name = "scope", length = 250)
	public String getScope() {
		return this.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "socialNetwork")
	public Set<UserNetwork> getUserNetworks()
	{
		return this.userNetworks;
	}

	public void setUserNetworks(Set<UserNetwork> userNetworks)
	{
		this.userNetworks = userNetworks;
	}

}
