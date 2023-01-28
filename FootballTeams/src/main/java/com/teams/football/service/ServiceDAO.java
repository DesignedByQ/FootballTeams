package com.teams.football.service;

import java.util.List;
import java.util.Map;

import com.teams.football.dto.TeamsDTO;



public interface ServiceDAO {
		
	TeamsDTO addTeamsService(TeamsDTO teamsDTO);
	
	List<TeamsDTO> getTeamsService();
		
	String deleteTeamsService(Integer id);
		
	TeamsDTO getTeamsServiceById(Integer id);
	
	TeamsDTO updateTeamsService(Integer id, Map<String, Object> field);
	
	TeamsDTO replaceTeamsService(Integer id, TeamsDTO teamsDTO);

}
