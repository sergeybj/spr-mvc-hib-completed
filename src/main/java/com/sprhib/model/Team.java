package com.sprhib.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="teams")
public class Team implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="team_id")
	private Integer id;
	@Column(name="team_name")
	private String name;
	@Column(name="team_rating")
	private Integer rating;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="team_org_id", nullable=false)
	private Organization organization;
	@ManyToMany(targetEntity=Member.class, fetch=FetchType.LAZY)
	@JoinTable(name="teams_members", joinColumns=@JoinColumn(name="team_id"), inverseJoinColumns=@JoinColumn(name="member_id"))
	private Set<Member>members = new HashSet<Member>(0);
	@Transient
	private Integer organizationId;
	
	public Team() {}
	public Team(Integer id, String name, Integer rating) {
		this.id = id;
		this.name = name;
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", rating=" + rating + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	public Set<Member> getMembers() {
		return members;
	}
	public void setMembers(Set<Member> members) {
		this.members = members;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	
	

	

}
