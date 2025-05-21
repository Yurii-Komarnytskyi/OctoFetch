package com.ykomarnytskyi.octofetch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "github")
public class GitHubPropertiesConfig {
	private String personalAccessToken;

	public String getPersonalAccessToken() {
		return personalAccessToken;
	}

	public void setPersonalAccessToken(String personalAccessToken) {
		this.personalAccessToken = personalAccessToken;
	}
}
