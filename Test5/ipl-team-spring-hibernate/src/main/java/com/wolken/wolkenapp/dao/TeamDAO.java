package com.wolken.wolkenapp.dao;

import java.util.List;

import com.wolken.wolkenapp.dto.TeamDTO;

public interface TeamDAO {

	public String save(TeamDTO teamDTO);

	public String deleteByTeamName(String teamName);
	
	public List<TeamDTO> getAllData();

	public String update(String captain, String teamName);

}
