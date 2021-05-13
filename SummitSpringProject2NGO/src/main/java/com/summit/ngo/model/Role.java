package com.summit.ngo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.summit.ngo.model.User;

@Entity(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int id;
	
	@OneToMany(mappedBy="role_id")
	private List<User> userList = new ArrayList<User>();
	
	private String name;
	private String role_type;
	private String evnt_view;
	private String evnt_mng;
	
	public Role(String name, String role_type, String evnt_view, String evnt_mng) {
		this.name=name;
		this.role_type=role_type;
		this.evnt_view=evnt_mng;
		this.evnt_mng=evnt_mng;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	public String getEvnt_view() {
		return evnt_view;
	}
	public void setEvnt_view(String evnt_view) {
		this.evnt_view = evnt_view;
	}
	public String getEvnt_mng() {
		return evnt_mng;
	}
	public void setEvnt_mng(String evnt_mng) {
		this.evnt_mng = evnt_mng;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
