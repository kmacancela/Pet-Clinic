package com.sherlockHomies.web;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.Pet;
import com.sherlockHomies.beans.User;
import com.sherlockHomies.orm.Facade;

@Service(value="businessDelegate")
public class BusinessDelegate implements ApplicationContextAware{

	private Facade facade;
	private ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
	
	/////////// USER ///////////
	/**
	 * Returns a user when given a username, if username is found
	 */
	public User findUser(String username) {
		User user = context.getBean(Facade.class).getUser(username);
		if(user == null){
			System.out.println("User not found");
			return null;
		}
		return user;
	}
	
	/**
	 * Returns a user when given userId
	 */
	public User getUserById(int id) {
		return context.getBean(Facade.class).getUser(id);
	}
	
	/**
	 * Returns if the owner is a vet or not when given a user
	 */
	public boolean isVet(User user){
		if(facade.userRole(user) == "Vet")
			return true;
		else return false;
	}
	
	//TODO deleted List<User> vets = context.getBean(Facade.class).getUserByRole("Vet");
	public List<User> getAllVets() { //TODO Dont need
		return context.getBean(Facade.class).getUsersByRole("Vet");
	}

	//////////////// Appointment ////////////////////
	
	/**
	 * Inserts an appointment when given a user Id, vet Id, pet Id, description, appt date, and card number
	 */
/*	public void insertAppt(int userId, int vetId, int petId, String description, String apptDate){
		facade.createAndInsertAppt(userId, vetId, petId, description, apptDate);
	}*/
	public void insertAppt(int userId, int vetId, int petId, String description, Timestamp apptDate){
		System.out.println("Entered insertAppt method in BD");
		context.getBean(Facade.class).createAndInsertAppt(userId, vetId, petId, description, apptDate);
	}

	public User getUserByUsername(String username) {
		return facade.getUser(username);
	}
	
	/**
	 * Returns upcoming appointments of a user when given userId
	 */
	public List<Appointment> getUpcoming(int userId){
		return context.getBean(Facade.class).getFutureAppointmentsByUser(userId);
	}
	
	/**
	 * Returns completed appoints of a user when given userId
	 */
	public List<Appointment> getCompleted(int userId){
		return context.getBean(Facade.class).getPastAppointmentsByUser(userId);
	}
	
	//////////PETS///////////////
	
	public List<Pet> getPetByUserId(int userId){
		return context.getBean(Facade.class).getPetByUserId(userId);
	}
	
}
