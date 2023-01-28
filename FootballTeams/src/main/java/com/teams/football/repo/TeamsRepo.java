package com.teams.football.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teams.football.entity.Teams;

@Repository
public interface TeamsRepo extends JpaRepository<Teams, Integer> {

}
