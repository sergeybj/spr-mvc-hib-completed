package com.sprhib.test.mockito;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sprhib.model.Organization;
import com.sprhib.service.OrganizationService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrganizationServiceMockitoTest {

	private static OrganizationService mockedOrganizationService;
	private static Organization organizationOne;
	private static Organization organizationTwo;

	@BeforeClass
	public static void setUp() {
		mockedOrganizationService = mock(OrganizationService.class);

		organizationOne = new Organization();
		String orgNameOne = "MockitoTestOrgNameOne";
		organizationOne.setId(1000001);
		organizationOne.setOrgName(orgNameOne);

		organizationTwo = new Organization();
		String orgNameTwo = "MockitoTestOrgNameTwo";
		organizationTwo.setId(1000002);
		organizationTwo.setOrgName(orgNameTwo);

		when(mockedOrganizationService.getOrganizations()).thenReturn(
				Arrays.asList(organizationOne, organizationTwo));
		when(mockedOrganizationService.getOrganization(1000001)).thenReturn(
				organizationOne);
		when(mockedOrganizationService.addOrganization(organizationTwo))
				.thenReturn(organizationTwo.getId());
	}

	@Test
	public void testGetOrganizations() {
		List<Organization> organizations = mockedOrganizationService
				.getOrganizations();
		assertEquals(2, organizations.size());
		assertEquals((Integer) 1000001, organizations.get(0).getId());
		assertEquals("MockitoTestOrgNameOne", organizations.get(0).getOrgName());
		assertEquals((Integer) 1000002, organizations.get(1).getId());
		assertEquals("MockitoTestOrgNameTwo", organizations.get(1).getOrgName());
	}

	@Test
	public void testGetOrganization() {
		Integer orgId = 1000001;
		Organization organization = mockedOrganizationService
				.getOrganization(orgId);
		assertEquals((Integer) 1000001, organization.getId());
		assertEquals("MockitoTestOrgNameOne", organization.getOrgName());
	}

	@Test
	public void testAddOrganization() {
		Organization organization = new Organization();
		String orgName = "MockitoTestOrgNameTwo";
		int insertedId = 1000002;
		organization.setId(insertedId);
		organization.setOrgName(orgName);
		Integer retrievedId = mockedOrganizationService
				.addOrganization(organizationTwo);
		assertEquals((Integer) insertedId, retrievedId);
	}

}
