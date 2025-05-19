package com.ykomarnytskyi.octofetch.dao;

import java.util.Objects;

public class RepoDetailsResponseDto extends BriefRepoDatailsResponseDto {
	private String language;
	private int stargazersCount;
	private int forksCount;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = (Objects.isNull(language)) ? "Couldn't infer the language" : language;
	}

	public int getStargazersCount() {
		return stargazersCount;
	}

	public void setStargazersCount(int stargazersCount) {
		this.stargazersCount = stargazersCount;
	}

	public int getForksCount() {
		return forksCount;
	}

	public void setForksCount(int forksCount) {
		this.forksCount = forksCount;
	}
}
