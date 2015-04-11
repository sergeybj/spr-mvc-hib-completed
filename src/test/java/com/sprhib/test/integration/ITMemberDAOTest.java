package com.sprhib.test.integration;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sprhib.dao.MemberDAO;
import com.sprhib.dao.TeamDAO;
import com.sprhib.model.Member;
import com.sprhib.model.Organization;
import com.sprhib.model.Team;

import static org.junit.Assert.*;

public class ITMemberDAOTest {
	@Test
	public void insertTeamsAssignedToOrganization() {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"integration_test_beans.xml");

		TeamDAO teamDAO = (TeamDAO) ctx.getBean("teamDAO");
		MemberDAO memberDAO = (MemberDAO) ctx.getBean("memberDAO");

		String orgName = "IntegrTestOrgName";
		Organization organization = new Organization();
		organization.setOrgName(orgName);

		Team teamOne = new Team();
		teamOne.setName("TeamOne");
		teamOne.setRating(6);
		teamOne.setOrganization(organization);

		Team teamTwo = new Team();
		teamTwo.setName("TeamTwo");
		teamTwo.setRating(7);
		teamTwo.setOrganization(organization);

		Team teamThree = new Team();
		teamThree.setName("TeamThree");
		teamThree.setRating(8);
		teamThree.setOrganization(organization);

		Team teamFour = new Team();
		teamFour.setName("TeamFour");
		teamFour.setRating(7);
		teamFour.setOrganization(organization);

		Member memberOne = new Member();
		memberOne.setFirstName("FirstNameOne");
		memberOne.setLastName("LastNameOne");

		Member memberTwo = new Member();
		memberTwo.setFirstName("FirstNameTwo");
		memberTwo.setLastName("LastNameTwo");

		Set<Team> setOne = new HashSet<>(0);
		setOne.add(teamOne);
		setOne.add(teamThree);

		Set<Team> setTwo = new HashSet<>(0);
		setTwo.add(teamTwo);
		setTwo.add(teamFour);
		
		memberOne.setTeams(setOne);
		memberTwo.setTeams(setTwo);

		int savedTeamIdOne = teamDAO.addTeam(teamOne);
		int savedTeamIdTwo = teamDAO.addTeam(teamTwo);
		int savedTeamIdThree = teamDAO.addTeam(teamThree);
		int savedTeamIdFour = teamDAO.addTeam(teamFour);

		int savedMemberIdOne = memberDAO.addMember(memberOne);
		int savedMemberIdTwo = memberDAO.addMember(memberTwo);

		Set<Team> retrievedTeamsOneThree = new HashSet<>(0);
		Set<Team> retrievedTeamsTwoFour = new HashSet<>(0);

		retrievedTeamsOneThree = memberDAO.getMember(savedMemberIdOne).getTeams();
		retrievedTeamsTwoFour = memberDAO.getMember(savedMemberIdTwo).getTeams();

		assertTrue(exists(savedTeamIdOne, retrievedTeamsOneThree));
		assertTrue(exists(savedTeamIdTwo, retrievedTeamsTwoFour));
		assertTrue(exists(savedTeamIdThree, retrievedTeamsOneThree));
    	assertTrue(exists(savedTeamIdFour, retrievedTeamsTwoFour));
	}

	static Boolean exists(int id, Set<Team> teams) {
		for (Team team : teams) {
			if (team.getId().equals((Integer)id))
				return true;
		}
		return false;
	}
}
