package com.sprhib.test.integration;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sprhib.dao.OrganizationDAO;
import com.sprhib.model.Organization;

import static org.junit.Assert.*;

public class ITOrganizationDAOTest {
	@Test
	public void insertAndReadOrganizationTest() {
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("integration_test_beans.xml");

		OrganizationDAO organizationDAO = (OrganizationDAO) ctx.getBean("organizationDAO");
		String orgName = "IntegrTestOrgName";
		Organization organization = new Organization();
		organization.setOrgName(orgName);
		
		int id = organizationDAO.addOrganization(organization);
		
		String retrieved = organizationDAO.getOrganization(id).getOrgName();
		assertEquals(orgName, retrieved);
		
		organizationDAO.deleteOrganization(id);
		
		assertNull(organizationDAO.getOrganization(id));
	}

}
