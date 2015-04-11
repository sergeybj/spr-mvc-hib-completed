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
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="members")
public class Member implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="member_id")
	private Integer id;
	@Column(name="member_first_name")
	private String firstName;
	@Column(name="member_last_name")
	private String lastName;
	@ManyToMany(targetEntity=Team.class, fetch=FetchType.EAGER)
	@JoinTable(name="teams_members", joinColumns=@JoinColumn(name="member_id"), inverseJoinColumns=@JoinColumn(name="team_id"))
	private Set<Team> teams = new HashSet<Team>(0);
	@Transient
	private Set<Integer>teamsIds = new HashSet<Integer>(0);
	
	public Member() {}
	
	public Member(Integer id, String firstName, String lastName, Set<Team> teams) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.teams = teams;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", teams=" + teams + "]";
	}
	
	public Set<Team> getTeams() {
		return teams;
	}
	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Integer> getTeamsIds() {
		return teamsIds;
	}
	public void setTeamsIds(Set<Integer> teamsIds) {
		this.teamsIds = teamsIds;
	}
}
