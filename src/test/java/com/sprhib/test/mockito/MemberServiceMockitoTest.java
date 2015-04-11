package com.sprhib.test.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sprhib.model.Member;
import com.sprhib.model.Organization;
import com.sprhib.model.Team;
import com.sprhib.service.MemberService;

public class MemberServiceMockitoTest {

	private static MemberService mockedMemberService;

	private static Team teamOne;
	private static Team teamTwo;
	private static Team teamThree;
	private static Team teamFour;

	private static Member memberOne;
	private static Member memberTwo;

	@BeforeClass
	public static void setUp() {
		mockedMemberService = mock(MemberService.class);

		String orgName = "IntegrTestOrgName";
		Organization organization = new Organization();
		organization.setOrgName(orgName);

		teamOne = new Team();
		teamOne.setId(500001);
		teamOne.setName("TeamOne");
		teamOne.setRating(6);
		teamOne.setOrganization(organization);

		teamTwo = new Team();
		teamTwo.setId(500002);
		teamTwo.setName("TeamTwo");
		teamTwo.setRating(7);
		teamTwo.setOrganization(organization);

		teamThree = new Team();
		teamThree.setId(500003);
		teamThree.setName("TeamThree");
		teamThree.setRating(8);
		teamThree.setOrganization(organization);

		teamFour = new Team();
		teamFour.setId(500004);
		teamFour.setName("TeamFour");
		teamFour.setRating(7);
		teamFour.setOrganization(organization);

		memberOne = new Member();
		memberOne.setId(300001);
		memberOne.setFirstName("FirstNameOne");
		memberOne.setLastName("LastNameOne");

		memberTwo = new Member();
		memberTwo.setId(300002);
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

		when(mockedMemberService.getMembers()).thenReturn(
				Arrays.asList(memberOne, memberTwo));
		when(mockedMemberService.getMember(300001)).thenReturn(memberOne);
		when(mockedMemberService.addMember(memberTwo)).thenReturn(
				memberTwo.getId());
	}

	@Test
	public void testGetMembers() {
		List<Member> members = mockedMemberService.getMembers();
		assertEquals(2, members.size());
		assertEquals((Integer) 300001, members.get(0).getId());
		assertEquals("FirstNameOne", members.get(0).getFirstName());
		assertEquals((Integer) 300002, members.get(1).getId());
		assertEquals("FirstNameTwo", members.get(1).getFirstName());

		assertEquals(2, members.get(0).getTeams().size());
		assertEquals(2, members.get(1).getTeams().size());
	}

	@Test
	public void testGetMember() {
		Integer memberId = 300001;
		Member member = mockedMemberService.getMember(memberId);
		assertEquals((Integer) memberId, member.getId());
		assertEquals("FirstNameOne", member.getFirstName());
		assertEquals(2, member.getTeams().size());
	}

	@Test
	public void testAddMember() {
		Member member = new Member();
		String firstName = "FirstNameTwo";
		int insertedId = 300002;
		member.setId(insertedId);
		member.setFirstName(firstName);
		Integer retrievedId = mockedMemberService.addMember(memberTwo);
		assertEquals((Integer) insertedId, retrievedId);
	}

}
