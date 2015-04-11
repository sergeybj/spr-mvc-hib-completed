package com.sprhib.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sprhib.model.Team;
@Transactional
public interface TeamDAO {
	
	public int addTeam(Team team);
	public void updateTeam(Team team);
	public Team getTeam(int id);
	public void deleteTeam(int id);
	public List<Team> getTeams();

}
