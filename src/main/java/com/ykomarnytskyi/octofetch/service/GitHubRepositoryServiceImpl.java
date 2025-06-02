package com.ykomarnytskyi.octofetch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ykomarnytskyi.octofetch.client.VersionControlRepoClient;
import com.ykomarnytskyi.octofetch.config.VersionControlPlatformPropertiesConfig;
import com.ykomarnytskyi.octofetch.dao.BriefRepoDatailsResponseDto;
import com.ykomarnytskyi.octofetch.dao.RepoDetailsResponseDto;

@Service
public class GitHubRepositoryServiceImpl implements RepositoryService {
	
	private final VersionControlPlatformPropertiesConfig platformPropsConfig;
	private final VersionControlRepoClient client;
	
	public GitHubRepositoryServiceImpl(VersionControlPlatformPropertiesConfig platformPropsConfig,
			VersionControlRepoClient client) {
		this.platformPropsConfig = platformPropsConfig;
		this.client = client;
	}


	@Override
	public RepoDetailsResponseDto fetchRepoDetailsByUserAndRepoNames(String userName, String repoName) {
		return client.fetchRepoDetailsByUserAndRepoNames(
				userName, 
				repoName, 
				platformPropsConfig.getPersonalAccessToken());
		
	}


	@Override
	public List<BriefRepoDatailsResponseDto> fetchUserRepositoriesByUserName(String userName) {
		return client.fetchUserRepositoriesByUserName(
				userName, 
				platformPropsConfig.getPersonalAccessToken());
	}

	
}
