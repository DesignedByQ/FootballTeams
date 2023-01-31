package com.teams.football.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.teams.football.dto.TeamsDTO;
import com.teams.football.entity.Teams;
import com.teams.football.exception.TeamsException;
import com.teams.football.repo.TeamsRepo;

@Service(value="serviceDAO")
public class ServiceDAOImpl implements ServiceDAO {
	//update to return a list of squad players when finished
	@Autowired
	private TeamsRepo teamsRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//add transactional
	@Override
	public TeamsDTO addTeamsService(TeamsDTO teamsDTO) {

		Teams tdto = teamsRepo.saveAndFlush(modelMapper.map(teamsDTO, Teams.class));
		
		return modelMapper.map(tdto, TeamsDTO.class);
		
	}

	@Override
	public List<TeamsDTO> getTeamsService() {

		List<Teams> t = teamsRepo.findAll();
		
		List<TeamsDTO> tdto = new ArrayList();
		
		for(Teams a: t) {
			
			tdto.add(modelMapper.map(a, TeamsDTO.class));
			
		}
		
		return tdto;
		
	}

	@Override
	public String deleteTeamsService(Integer id) {

		teamsRepo.deleteById(id);
		
		return "Team " + id + " has been relegated!";
		
	}

	@Override
	public TeamsDTO getTeamsServiceById(Integer id) throws TeamsException{

		Optional<Teams> ot = teamsRepo.findById(id); //if not using else throw then make team optional
		
		if(ot.isEmpty()) {
			
			throw new TeamsException("Team does not exist with that ID");
			
		} else {
		
			return modelMapper.map(ot.get(), TeamsDTO.class);
		
		}
		
	}

	@Override
	public TeamsDTO updateTeamsService(Integer id, Map<String, Object> fields) {

		Optional<Teams> t = teamsRepo.findById(id);
		
		if(t.isPresent()) {
			
			fields.forEach((key, value)->{
				
				Field field = ReflectionUtils.findRequiredField(Teams.class, key);
				
				field.setAccessible(true);
				
				ReflectionUtils.setField(field, t.get(), value);
				
			});
			
			return modelMapper.map(teamsRepo.save(t.get()), TeamsDTO.class);
			
		}
		
		return null;
			
	}


	@Override
	public TeamsDTO replaceTeamsService(Integer id, TeamsDTO teamsDTO) {

		Optional<Teams> t = teamsRepo.findById(id);
		
		//Optional<Players> p = teamsRepo.findById(teamsDTO.getTeamId());//rest template here
		
		if(t.isPresent()) {
			
			t.get().setTeamId(teamsDTO.getTeamId()); 
			t.get().setName(teamsDTO.getName());	
			t.get().setStadium(teamsDTO.getStadium());		
			t.get().setCapacity(teamsDTO.getCapacity());		
			t.get().setCity(teamsDTO.getCity());		
			t.get().setValue(teamsDTO.getValue());		
			
		}
		
		return modelMapper.map(teamsRepo.save(t.get()), TeamsDTO.class);
	}

}
