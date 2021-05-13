package com.summit.ngo.evnt.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.summit.ngo.registration.model.Registration;


@Entity
@Table
public class Event {
	
	@Id
	@GeneratedValue
	Integer id;
	String name;
	String description;
	String category;
	String location;
	Timestamp start_date;
	Timestamp end_date;
	@OneToMany(mappedBy = "evntmodel",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Registration> registrationModel;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(Integer id, String name, String description, String category, String location,
			Timestamp start_date, Timestamp end_date, Set<Registration> registrationModel) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.location = location;
		this.start_date = start_date;
		this.end_date = end_date;
		this.registrationModel = registrationModel;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	public Timestamp getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}

	public Set<Registration> getRegistrationModel() {
		return registrationModel;
	}

	public void setRegistrationModel(Set<Registration> registrationModel) {
		this.registrationModel = registrationModel;
	}

	@Override
	public String toString() {
		return "EvntModel [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", location=" + location + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", registrationModel=" + registrationModel + "]";
	}

	
	
	
	
}
