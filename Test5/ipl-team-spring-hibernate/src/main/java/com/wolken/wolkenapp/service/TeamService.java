package com.wolken.wolkenapp.service;

import java.util.List;

import com.wolken.wolkenapp.dto.TeamDTO;

public interface TeamService {
	public String validateAndSave(TeamDTO teamDTO);

	public String validateAndDelete(String teamName);
	
	public List<TeamDTO> validateAndGet();

	String validateAndUpdate(String captain, String teamName);
}
