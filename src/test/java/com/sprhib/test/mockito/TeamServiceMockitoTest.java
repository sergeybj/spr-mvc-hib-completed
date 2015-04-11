package com.sprhib.test.mockito;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sprhib.model.Organization;
import com.sprhib.model.Team;
import com.sprhib.service.TeamService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TeamServiceMockitoTest {

	private static TeamService mockedTeamService;
	private static Organization organization;
	private static Team teamOne;
	private static Team teamTwo;

	@BeforeClass
	public static void setUp() {
		mockedTeamService = mock(TeamService.class);

		String orgName = "MockitoTestOrgName";
		organization = new Organization();
		organization.setId(1000001);
		organization.setOrgName(orgName);

		teamOne = new Team();
		teamOne.setId(5000001);
		teamOne.setName("MockitoTestTeamOne");
		teamOne.setRating(8);

		teamTwo = new Team();
		teamTwo.setId(5000002);
		teamTwo.setName("MockitoTestTeamTwo");
		teamTwo.setRating(7);

		teamOne.setOrganization(organization);
		teamTwo.setOrganization(organization);

		when(mockedTeamService.getTeams()).thenReturn(
				Arrays.asList(teamOne, teamTwo));
		when(mockedTeamService.getTeam(5000001)).thenReturn(teamOne);
		when(mockedTeamService.addTeam(teamTwo)).thenReturn(teamTwo.getId());

	}

	@Test
	public void testGetTeams() {
		List<Team> teams = mockedTeamService.getTeams();
		assertEquals(2, teams.size());
		assertEquals((Integer) 5000001, teams.get(0).getId());
		assertEquals("MockitoTestTeamOne", teams.get(0).getName());
		assertEquals((Integer) 5000002, teams.get(1).getId());
		assertEquals("MockitoTestTeamTwo", teams.get(1).getName());

		assertEquals(organization.getOrgName(), teams.get(0).getOrganization()
				.getOrgName());
	}

	@Test
	public void testGetTeam() {
		Integer orgId = 5000001;
		Team team = mockedTeamService.getTeam(orgId);
		assertEquals((Integer) 5000001, team.getId());
		assertEquals("MockitoTestTeamOne", team.getName());
	}

	@Test
	public void testAddTeam() {
		Team team = new Team();
		String teamName = "MockitoTestTeamTwo";
		int insertedId = 5000002;
		team.setId(insertedId);
		team.setName(teamName);
		Integer retrievedId = (Integer) mockedTeamService.addTeam(teamTwo);
		assertEquals((Integer) insertedId, retrievedId);
	}

}
