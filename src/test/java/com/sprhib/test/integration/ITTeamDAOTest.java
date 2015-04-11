package com.sprhib.test.integration;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sprhib.dao.OrganizationDAO;
import com.sprhib.dao.TeamDAO;
import com.sprhib.model.Organization;
import com.sprhib.model.Team;

import static org.junit.Assert.*;

public class ITTeamDAOTest {
	@Test
	public void insertTeamsAssignedToOrganization() {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("integration_test_beans.xml");

		OrganizationDAO organizationDAO = (OrganizationDAO) ctx.getBean("organizationDAO");
		TeamDAO teamDAO = (TeamDAO) ctx.getBean("teamDAO");

		String orgName = "IntegrTestOrgName";
		Organization organization = new Organization();
		organization.setOrgName(orgName);

		int savedOrgId = organizationDAO.addOrganization(organization);

		Team teamOne = new Team();
		teamOne.setName("IntegrTestTeamOne");
		teamOne.setRating(8);

		Team teamTwo = new Team();
		teamTwo.setName("IntegrTestTeamTwo");
		teamTwo.setRating(7);

		teamOne.setOrganization(organization);
		teamTwo.setOrganization(organization);

		int savedTeamIdOne = teamDAO.addTeam(teamOne);
		int savedTeamIdTwo = teamDAO.addTeam(teamTwo);

		int retrievedJoinedOrgIdOne = teamDAO.getTeam(savedTeamIdOne).getOrganization().getId();
		int retrievedJoinedOrgIdTwo = teamDAO.getTeam(savedTeamIdTwo).getOrganization().getId();

		assertEquals(savedOrgId, retrievedJoinedOrgIdOne);
		assertEquals(savedOrgId, retrievedJoinedOrgIdTwo);
	}
}
