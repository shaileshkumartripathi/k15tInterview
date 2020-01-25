package com.k15t.pat;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.k15t.pat.registration.RegistrationForm;
import com.k15t.pat.registration.RegistrationFormRepository;
import com.k15t.pat.registration.RegistrationResource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class RegistrationFormTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	RegistrationResource registrationResource;
	


	@Test
	public void testRegistrationForm() {
		RegistrationForm savedInDb = entityManager.persist(getRegistrationForm());
		String getFromDb = registrationResource.save(savedInDb);
		boolean dataSaved =registrationResource.hasDataSaved(getRegistrationForm());
		List<RegistrationForm> formList=registrationResource.getAllData();
		assertEquals(true, getFromDb);
	}
	
	private RegistrationForm getRegistrationForm() {
		RegistrationForm registrationForm = new RegistrationForm();
		registrationForm.setName("Jhon");
		registrationForm.setAddress("South-east");
		registrationForm.setEmail("abc@abc.com");
		registrationForm.setPhoneNumber("12345678");

		return registrationForm;
	}
}
