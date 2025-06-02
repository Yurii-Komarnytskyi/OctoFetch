package com.ykomarnytskyi.octofetch.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.ykomarnytskyi.octofetch.dao.BriefRepoDatailsResponseDto;
import com.ykomarnytskyi.octofetch.dao.RepoDetailsResponseDto;

@FeignClient(name = "${platform.api.name}", url = "${platform.api}")
public interface VersionControlRepoClient {
	
	@GetMapping("/repos/{userName}/{repoName}")
	public RepoDetailsResponseDto fetchRepoDetailsByUserAndRepoNames(
			@PathVariable("userName") String userName, 
			@PathVariable("repoName") String repoName,
			@RequestHeader("Authorization") String authorization );
	
	@GetMapping("/users/{userName}/repos")
	List<BriefRepoDatailsResponseDto> fetchUserRepositoriesByUserName(
			@PathVariable("userName") String userName, 
			@RequestHeader("Authorization") String authorization);
}
