package com.summit.ngo.registration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.summit.ngo.evnt.model.EvntModel;

@Entity
@Table
public class RegistrationModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String eventName;
	String fistName;
	String lastName;
	String emailId;
	String contact;
	String address;
	Integer adultQty;
	Integer childQty;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="event_id")
	private EvntModel evntModel;
	public RegistrationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegistrationModel(Integer id, String eventName, String fistName, String lastName, String emailId,
			String contact, String address, Integer adultQty, Integer childQty, User user, EvntModel evntModel) {
		super();
		this.id = id;
		this.eventName = eventName;
		this.fistName = fistName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contact = contact;
		this.address = address;
		this.adultQty = adultQty;
		this.childQty = childQty;
		this.user = user;
		this.evntModel = evntModel;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getAdultQty() {
		return adultQty;
	}
	public void setAdultQty(Integer adultQty) {
		this.adultQty = adultQty;
	}
	public Integer getChildQty() {
		return childQty;
	}
	public void setChildQty(Integer childQty) {
		this.childQty = childQty;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public EvntModel getEvntModel() {
		return evntModel;
	}
	public void setEvntModel(EvntModel evntModel) {
		this.evntModel = evntModel;
	}
	@Override
	public String toString() {
		return "RegistrationModel [id=" + id + ", eventName=" + eventName + ", fistName=" + fistName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", contact=" + contact + ", address=" + address + ", adultQty="
				+ adultQty + ", childQty=" + childQty + ", evntModel=" + evntModel + "]";
	}
	
	
}
