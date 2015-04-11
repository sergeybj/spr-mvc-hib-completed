package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sprhib.model.Organization;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

	@Autowired
	SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public int addOrganization(Organization organization) {
		getCurrentSession().save(organization);
		return organization.getId();
	}

	@Override
	public void updateOrganization(Organization organization) {
		Organization orgToUpdate = getOrganization(organization.getId());
		orgToUpdate.setOrgName(organization.getOrgName());
		getCurrentSession().save(orgToUpdate);
	}

	@Override
	public Organization getOrganization(int id) {
		Organization organization = (Organization) getCurrentSession().get(
				Organization.class, id);
		return organization;
	}

	@Override
	public void deleteOrganization(int id) {
		Organization organization = (Organization) getCurrentSession().get(
				Organization.class, id);
		if (organization != null)
			getCurrentSession().delete(organization);
	}

	@SuppressWarnings("unchecked")
	public List<Organization> getOrganizations() {
		List<Organization> list = getCurrentSession().createQuery(
				"from Organization").list();
		return list;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
