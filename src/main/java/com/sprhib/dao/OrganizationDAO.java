package com.sprhib.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sprhib.model.Organization;
@Transactional
public interface OrganizationDAO {
	
	public int addOrganization(Organization organization);
	public void updateOrganization(Organization organization);
	public Organization getOrganization(int id);
	public void deleteOrganization(int id);
	public List<Organization> getOrganizations();

}
