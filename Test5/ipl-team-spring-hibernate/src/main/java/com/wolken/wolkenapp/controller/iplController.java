package com.wolken.wolkenapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wolken.wolkenapp.dto.TeamDTO;
import com.wolken.wolkenapp.service.TeamService;


@Component
@RequestMapping("/")
public class iplController {
	
	@Autowired
	TeamService teamService ;
	
	@RequestMapping("/team.mel")
	public String save(@ModelAttribute TeamDTO teamDTO, HttpServletRequest req) {
		
		String msg = teamService.validateAndSave(teamDTO);
		
		req.setAttribute("msg", msg);
		
		return "final.jsp";
		
	}
	
	@RequestMapping("/delete.mel")
	public String delete(HttpServletRequest req) {
		String teamName = req.getParameter("teamName");
		String delmsg = teamService.validateAndDelete(teamName);
		req.setAttribute("delmsg", delmsg);
		return "final.jsp";
	}
	
	@RequestMapping("/update.mel")
	public String update(HttpServletRequest req) {
		String captain = req.getParameter("captain");
		String teamName = req.getParameter("teamName");
		String upmsg = teamService.validateAndUpdate(captain , teamName);
		req.setAttribute("upmsg", upmsg);
		return "final.jsp";
		
	}
	
	@RequestMapping("/display.mel")
	public String get(HttpServletRequest req) {
		List<TeamDTO> tlist = teamService.validateAndGet();
		
		req.setAttribute("tlist", tlist);
		 
		return "get.jsp";
}

}
