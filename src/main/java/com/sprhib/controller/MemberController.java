package com.sprhib.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sprhib.model.Member;
import com.sprhib.model.Team;
import com.sprhib.service.MemberService;
import com.sprhib.service.TeamService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addMemberPage() {
		ModelAndView modelAndView = new ModelAndView("add-member-form");
		modelAndView.addObject("member", new Member());
		List<Team> teams = teamService.getTeams();
		List<Integer> teamIdList = new ArrayList<Integer>();
		for (Team team : teams) {
			teamIdList.add(team.getId());
		}
		modelAndView.addObject("teamIdList", teamIdList);
		modelAndView.addObject("teams", teams);
		return modelAndView;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingMember(@ModelAttribute Member member, @RequestParam List<Integer> teamsIds) {
		
		System.out.println(member.toString());
		
		Set<Team> teams = new HashSet<Team>(0);
		for (Integer id : teamsIds) {
			System.out.println("id = " + id);
			teams.add(teamService.getTeam(id));
		}		
		member.setTeams(teams);
		
		ModelAndView modelAndView = new ModelAndView("list-of-members");
		memberService.addMember(member);
		String message = "Member was successfully added.";
		modelAndView.addObject("message", message);
		List<Member> members = memberService.getMembers();
		modelAndView.addObject("members", members);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfMembers() {
		ModelAndView modelAndView = new ModelAndView("list-of-members");
		List<Member> members = memberService.getMembers();
		System.out.println("TEST");
		modelAndView.addObject("members", members);
		
		
		for (Member member : members) {
			System.out.println(member.toString());
			for (Team team : member.getTeams()) {
				System.out.println("**********" + team.toString());
			}
		}
		
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editMemberPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-member-form");
		Member member = memberService.getMember(id);
		modelAndView.addObject("member", member);
		List<Team> teams = teamService.getTeams();
		List<Integer> teamsIds = new ArrayList<Integer>();
		for (Team team : teams) {
			teamsIds.add(team.getId());
		}
		
		modelAndView.addObject("teams", teams);
		modelAndView.addObject("teamsIds", teamsIds);
		
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editingMember(@ModelAttribute Member member, @RequestParam Set<Integer> teamsIds) {
		
		ModelAndView modelAndView = new ModelAndView("list-of-members");
		
		Set<Team> teams = new HashSet<Team>(0);
		for (Integer id : teamsIds) {
			teams.add(teamService.getTeam(id));
		}
		member.setTeams(teams);
		memberService.updateMember(member);
		String message = "Member was successfully edited.";
		modelAndView.addObject("message", message);
		List<Member> members = memberService.getMembers();
		modelAndView.addObject("members", members);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteMember(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("list-of-members");
		memberService.deleteMember(id);
		String message = "Member was successfully deleted.";
		modelAndView.addObject("message", message);
		List<Member> members = memberService.getMembers();
		modelAndView.addObject("members", members);
		return modelAndView;
	}

}
