package com.teams.football.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.teams.football.dto.TeamsDTO;
import com.teams.football.exception.TeamsException;
import com.teams.football.service.ServiceDAOImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
@Validated
@CrossOrigin
public class ControllerAPI {
	
	
	@Autowired
	private ServiceDAOImpl serviceDAOImpl;
	
	
	@PostMapping(value = "/promotion", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<TeamsDTO> addTeams(@Valid @RequestBody TeamsDTO teamsDTO) {
		System.out.println(2222);
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceDAOImpl.addTeamsService(teamsDTO));
		
	}
	
	@GetMapping(value = "/allteams", consumes = {MediaType.ALL_VALUE}, produces = {"application/json", "application/xml"})
	public ResponseEntity<List<TeamsDTO>> getTeams(){
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceDAOImpl.getTeamsService());
		
	}
	
	@DeleteMapping(value = "/relegation/{id}", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<String> deleteTeam(@PathVariable Integer id) {
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceDAOImpl.deleteTeamsService(id));
		
	}
	
	@GetMapping(value = "/team/{id}", consumes = {MediaType.ALL_VALUE})
	public ResponseEntity<TeamsDTO> getTeam(@PathVariable Integer id) throws TeamsException{
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceDAOImpl.getTeamsServiceById(id));
		
	}
	
	@PatchMapping(value ="/update/{id}")
	public ResponseEntity<TeamsDTO> updatePlayer(@PathVariable Integer id, @RequestBody Map<String, Object> fields) {
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceDAOImpl.updateTeamsService(id, fields));
		
	}
	
	@PutMapping(value ="/replace/{id}")
	public ResponseEntity<TeamsDTO> replacePlayer(@PathVariable Integer id, @RequestBody TeamsDTO teamsDTO) {
		
		return ResponseEntity.status(HttpStatus.OK).body(serviceDAOImpl.replaceTeamsService(id, teamsDTO));
	}


}
