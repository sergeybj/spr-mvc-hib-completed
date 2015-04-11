package com.sprhib.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "organizations")
public class Organization implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "org_id")
	private Integer id;
	@Column(name = "org_name")
	private String orgName;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_org_id")
	private Set<Team> orgTeams = new HashSet<Team>(0);

	public Organization() {}

	public Organization(Integer id, String orgName, Set<Team> orgTeams) {
		this.id = id;
		this.orgName = orgName;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public void setOrgTeams(Set<Team> orgTeams) {
		this.orgTeams = orgTeams;
	}
	public Set<Team> getOrgTeams() {
		return this.orgTeams;
	}

}
