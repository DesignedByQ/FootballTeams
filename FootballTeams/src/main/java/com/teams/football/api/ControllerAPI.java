package com.teams.football.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.dto.PlayerDTO;
import com.football.dto.TeamDTO;
import com.football.service.ServiceDAOImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
public class ControllerAPI {
	
	
	@Autowired
	private ServiceDAOImpl serviceDAOImpl;
	
	
	@PostMapping(value = "/promotion", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<TeamDTO> addTeam(@Valid @RequestBody TeamDTO teamDTO) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceDAOImpl.addTeamService(teamDTO));
		
	}

}
