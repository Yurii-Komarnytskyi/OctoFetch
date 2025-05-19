package com.ykomarnytskyi.octofetch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ykomarnytskyi.octofetch.dao.BriefRepoDatailsResponseDto;
import com.ykomarnytskyi.octofetch.dao.RepoDetailsResponseDto;
import com.ykomarnytskyi.octofetch.service.GitHubRepositoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/github")
public class GitHubRepositoryController {

	private final GitHubRepositoryService repositoryService;

	@Autowired
	public GitHubRepositoryController(GitHubRepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	@Operation(summary = "Get list of repositories for a GitHub user", description = "Fetches all public repositories for the specified GitHub username.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved repositories"),
        @ApiResponse(responseCode = "404", description = "User not found"),
        @ApiResponse(responseCode = "401", description = "Unauthorized request")
    })
	@GetMapping("/users/{userName}/repos")
	public List<BriefRepoDatailsResponseDto> fetchUserRepositories(
			@Parameter(description = "GitHub username") @PathVariable("userName") String userName) {
		return repositoryService.fetchUserRepositoriesByUserName(userName);
	}
	
	@Operation(summary = "Get details of a specific repository", description = "Fetches details and stats for a specific repository owned by the given username.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved repository details"),
        @ApiResponse(responseCode = "404", description = "Repository or user not found"),
        @ApiResponse(responseCode = "401", description = "Unauthorized request")
    })
	@GetMapping("/repos/{userName}/{repoName}")
	public RepoDetailsResponseDto fetchUserRepositoryDetails(
			@Parameter(description = "GitHub username") @PathVariable("userName") String userName,
			@Parameter(description = "Repository name") @PathVariable("repoName") String repoName) {
		return repositoryService.fetchRepoDetailsByUserAndRepoNames(userName, repoName);
	}
}
