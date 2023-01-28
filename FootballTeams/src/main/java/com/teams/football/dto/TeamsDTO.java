package com.teams.football.dto;

import jakarta.validation.constraints.NotNull;

public class TeamsDTO {
	
	private Integer teamId;
	@NotNull(message="team name must not be null")
	private String name;
	private String stadium;
	private long capacity;
	private String city;
	private long value;
	
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "TeamDTO [teamId=" + teamId + ", name=" + name + ", stadium=" + stadium + ", capacity=" + capacity
				+ ", city=" + city + ", value=" + value + "]";
	}
	
	
	
}

