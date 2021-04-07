package com.wolken.wolkenapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wolken.wolkenapp.dao.TeamDAO;
import com.wolken.wolkenapp.dto.TeamDTO;
import com.wolken.wolkenapp.exception.TeamException;
import com.wolken.wolkenapp.exception.TeamIdException;
import com.wolken.wolkenapp.exception.TeamNameException;

@Component
public class TeamServiceImpl implements TeamService{
	@Autowired
	TeamDAO teamDAO;

	@Override
	public String validateAndSave(TeamDTO teamDTO) {
		try {
			System.out.println("Inside save - service");

			if(teamDTO != null) {
				
				if(teamDTO.getTeamId() > 0) {
					
					if(teamDTO.getTeamName() != null && teamDTO.getTeamName().length() > 1){
						String msg = teamDAO.save(teamDTO);
						return msg;
					}else {
						throw new TeamNameException();
					}
					
				}else {
					throw new TeamIdException();
				}
				
			}else {
				throw new TeamException();
			}
			
		} catch (TeamNameException | TeamIdException | TeamException | NullPointerException e) {
			System.out.println(e);
			return "Data cannot be added ";
		}
	
		
	}

	@Override
	public String validateAndDelete(String teamName) {
		try {
			System.out.println("Inside delete - service");

			if(teamName != null){
				String delmsg = teamDAO.deleteByTeamName(teamName);
			return delmsg;
			
			}else {
				throw new TeamNameException();
			}
		} catch (TeamNameException | NullPointerException e) {
			System.out.println(e);
			return "Data cannot be deleted " ;
		}
		
	}

	@Override
	public String validateAndUpdate(String captain, String teamName) {
		try {
			if(captain.length() > 2) {
				String upmsg = teamDAO.update( captain, teamName);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "Data cannot be updated";
	}

	@Override
	public List<TeamDTO> validateAndGet() {
		try {
			List<TeamDTO> tdto = teamDAO.getAllData(); 
			
			return tdto;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
