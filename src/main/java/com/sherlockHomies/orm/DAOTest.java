package com.sherlockHomies.orm;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.Invoice;
import com.sherlockHomies.beans.Pet;
import com.sherlockHomies.beans.Rating;
import com.sherlockHomies.beans.User;

public class DAOTest {

	private static ApplicationContext ctxt;
	
	@BeforeClass
	public static void setup(){
		ctxt = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	/**
	 * Tested methods:
	 * 	UserDAO
	 * 		getAll
	 * 		getbyId
	 */
	
	@Ignore
	@Test
	public void testUserGetAll(){
		List<User> users = ctxt.getBean(UserDAO.class).getAll();
		System.out.println(users);
	}
	
	@Ignore
	@Test
	public void testUserGetById(){
		User userman = ctxt.getBean(UserDAO.class).getById(1);
		System.out.println(userman);
	}
	
	@Ignore
	@Test
	public void testPetGetAll(){
		List<Pet> pets = ctxt.getBean(PetDAO.class).getAll();
		System.out.println(pets);
	}
	
	@Ignore
	@Test
	public void testPetGetById(){
		Pet pet = ctxt.getBean(PetDAO.class).getById(3);
		System.out.println(pet);
	}
	
	@Ignore
	@Test
	public void testAppointmentGetAll(){
		List<Appointment> appt = ctxt.getBean(AppointmentDAO.class).getAll();
		System.out.println(appt);
	}
	
	@Ignore
	@Test
	public void getAppointmentById(){
		Appointment appt = ctxt.getBean(AppointmentDAO.class).getById(1);
		System.out.println(appt);
	}
	
	@Ignore
	@Test
	public void testInvoiceGetAll(){
		List<Invoice> invs = ctxt.getBean(InvoiceDAO.class).getAll();
		System.out.println(invs);
	}
	
	@Ignore
	@Test
	public void testInvoiceGetById(){
		Invoice inv = ctxt.getBean(InvoiceDAO.class).getById(31);
		System.out.println(inv);
	}
	
	@Ignore
	@Test
	public void testRatingGetAll(){
		List<Rating> ratings = ctxt.getBean(RatingDAO.class).getAll();
		System.out.println(ratings);
	}
	
	@Ignore
	@Test
	public void testRatingGetById(){
		Rating r = ctxt.getBean(RatingDAO.class).getRatingById(1);
		System.out.println(r);
	}
}