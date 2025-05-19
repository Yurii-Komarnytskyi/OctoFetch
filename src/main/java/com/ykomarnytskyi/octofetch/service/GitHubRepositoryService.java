package com.ykomarnytskyi.octofetch.service;

import java.util.List;

import com.ykomarnytskyi.octofetch.dao.RepoDetailsResponseDto;
import com.ykomarnytskyi.octofetch.dao.BriefRepoDatailsResponseDto;

public interface GitHubRepositoryService {
	RepoDetailsResponseDto fetchRepoDetailsByUserAndRepoNames(String userName, String repoName);
	List<BriefRepoDatailsResponseDto> fetchUserRepositoriesByUserName(String userName);
}
