package com.ykomarnytskyi.octofetch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ykomarnytskyi.octofetch.dao.RepoDetailsResponseDto;
import com.ykomarnytskyi.octofetch.dao.BriefRepoDatailsResponseDto;

@Service
public class GitHubRepositoryServiceImpl implements GitHubRepositoryService {
	
	private final WebClient webClient;
	private static final String GITHUB_API = "https://api.github.com";
	private static final String AUTHORIZATION = "Authorization";
	
	@Autowired
	public GitHubRepositoryServiceImpl(WebClient.Builder builder, @Value("${gitHub.personalAccessToken}") String token) {
		this.webClient = builder
				.baseUrl(GITHUB_API)
				.defaultHeader(AUTHORIZATION, "token ".concat(token))
				.build();
	}

	@Override
	public RepoDetailsResponseDto fetchRepoDetailsByUserAndRepoNames(String userName, String repoName) {
		return null;
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
