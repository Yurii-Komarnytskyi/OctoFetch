package com.ykomarnytskyi.octofetch.dao;

import java.util.Objects;

public class BriefRepoDatailsResponseDto {
	protected String name;
	protected String description;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = (Objects.isNull(description) ? "No description provided" : description);
	}
}
