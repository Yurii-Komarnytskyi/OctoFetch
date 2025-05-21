package com.ykomarnytskyi.octofetch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ykomarnytskyi.octofetch.config.GitHubPropertiesConfig;
import com.ykomarnytskyi.octofetch.dao.BriefRepoDatailsResponseDto;
import com.ykomarnytskyi.octofetch.dao.RepoDetailsResponseDto;

@Service
public class GitHubRepositoryServiceImpl implements GitHubRepositoryService {
	
	private final WebClient webClient;
	private final GitHubPropertiesConfig gitHubPropertiesConfig;
	private static final String GITHUB_API = "https://api.github.com";
	
	@Autowired
	public GitHubRepositoryServiceImpl(WebClient.Builder builder, GitHubPropertiesConfig properties) {
		this.gitHubPropertiesConfig = properties;
		this.webClient = builder
				.baseUrl(GITHUB_API)
				.defaultHeader(HttpHeaders.AUTHORIZATION, "token ".concat(gitHubPropertiesConfig.getPersonalAccessToken()))
				.build();
	}

	@Override
	public RepoDetailsResponseDto fetchRepoDetailsByUserAndRepoNames(String userName, String repoName) {
		return webClient
				.get()
				.uri("/repos/{userName}/{repoName}", userName, repoName)
				.retrieve()
				.bodyToMono(RepoDetailsResponseDto.class)
				.block();
	}

	@Override
	public List<BriefRepoDatailsResponseDto> fetchUserRepositoriesByUserName(String userName) {
		return webClient
				.get()
				.uri("/users/{username}/repos", userName)
				.retrieve()
				.bodyToFlux(BriefRepoDatailsResponseDto.class)
				.collectList()
				.block();
	}

	
}
