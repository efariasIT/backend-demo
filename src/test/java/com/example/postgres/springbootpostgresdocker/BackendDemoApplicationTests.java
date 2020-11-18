package com.example.postgres.springbootpostgresdocker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.postgres.springbootpostgresdocker.entity.PersonModel;
import com.example.postgres.springbootpostgresdocker.repository.PersonRespository;
import com.example.postgres.springbootpostgresdocker.service.IPersonService;

@SpringBootTest
class BackendDemoApplicationTests {

	@Autowired
	private IPersonService personService;

	@MockBean
	private PersonRespository personRespository;

	@Test
	void obtenerTodasLasPersonasTest() {
		when(personRespository.findAll())
				.thenReturn(Stream
						.of(new PersonModel((long) 1, "1031137222", "Pablo", "M", "C"),
								new PersonModel((long) 2, "1032123654", "Maria", "F", "M"))
						.collect(Collectors.toList()));

		assertEquals(2, personService.obtenerPersonas().size());
	}

	@Test
	void crearPersonaTest() {
		PersonModel persona = new PersonModel(1L, "1031131131", "Test", "M", "F");
		when(personRespository.save(persona)).thenReturn(persona);
		assertEquals(persona, personRespository.save(persona));
	}
}
