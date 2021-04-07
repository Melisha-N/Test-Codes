package com.wolken.wolkenapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@Entity
@Table(name="ipl_teams_details")
public class TeamDTO {
	@Id
	@Column(name="team_id")
	private int teamId;
	
	@Column(name="team_name")
	private String teamName;
	
	@Column(name="team_home_ground")
	private String homeGround;
	
	@Column(name="team_captain")
	private String captain;

}
 