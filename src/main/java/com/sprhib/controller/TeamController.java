package com.sprhib.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Organization;
import com.sprhib.model.Team;
import com.sprhib.service.OrganizationService;
import com.sprhib.service.TeamService;

@Controller
@RequestMapping(value = "/team")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@Autowired
	private OrganizationService organizationService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addTeamPage() {
		ModelAndView modelAndView = new ModelAndView("add-team-form");
		modelAndView.addObject("team", new Team());
		List<Organization> organizationList = organizationService
				.getOrganizations();
		List<Integer> organizationIdList = new ArrayList<Integer>();
		for (Organization organization : organizationList) {
			organizationIdList.add(organization.getId());
		}
		modelAndView.addObject("organizationList", organizationList);
		modelAndView.addObject("organizationIdList", organizationIdList);
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addingTeam(@ModelAttribute Team team,
			@RequestParam Integer organizationId) {
		Organization organization = organizationService
				.getOrganization(organizationId);
		team.setOrganization(organization);
		ModelAndView modelAndView = new ModelAndView("list-of-teams");
		teamService.addTeam(team);
		List<Team> teams = teamService.getTeams();
		modelAndView.addObject("teams", teams);
		String message = "Team was successfully added.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value = "/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("list-of-teams");
		List<Team> teams = teamService.getTeams();
		System.out.println("TEST");
		modelAndView.addObject("teams", teams);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-team-form");
		System.out.println("search team by id = " + id);
		Team team = teamService.getTeam(id);
		modelAndView.addObject("team", team);
		System.out.println("found team name = " + team.getName());
		List<Organization> organizationList = organizationService.getOrganizations();
		modelAndView.addObject("organizationList", organizationList);
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editingTeam(@ModelAttribute Team team,
			@RequestParam Integer organizationId) {
		ModelAndView modelAndView = new ModelAndView("list-of-teams");
		Organization organization = organizationService.getOrganization(organizationId);
		team.setOrganization(organization);
		System.out.println(team.getOrganization());
		teamService.updateTeam(team);
		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);
		List<Team> teams = teamService.getTeams();
		modelAndView.addObject("teams", teams);
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("list-of-teams");
		teamService.deleteTeam(id);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		List<Team> teams = teamService.getTeams();
		modelAndView.addObject("teams", teams);
		return modelAndView;
	}

}
