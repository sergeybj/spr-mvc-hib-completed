package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.OrganizationDAO;
import com.sprhib.model.Organization;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService{
	
	@Autowired
	OrganizationDAO organizationDAO;

	@Override
	public int addOrganization(Organization organization) {
		return organizationDAO.addOrganization(organization);
	}

	@Override
	public void updateOrganization(Organization organization) {
		organizationDAO.updateOrganization(organization);
	}

	@Override
	public Organization getOrganization(int id) {
		return organizationDAO.getOrganization(id);
	}

	@Override
	public void deleteOrganization(int id) {
		organizationDAO.deleteOrganization(id);
	}

	@Override
	public List<Organization> getOrganizations() {
		return organizationDAO.getOrganizations();
	}

}
