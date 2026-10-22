package com.example.demo;

import com.example.demo.bo.WithdrawRequestDTO;
import com.example.demo.service.BankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
    BankService bankService;

	@Test
	void contextLoads() {
	}

	@Test
	void demo(){
		// Tester que tout les returns possibles retourne le code métier attendu

		// Cas / return 1 -> montant negatif
		WithdrawRequestDTO dto = new WithdrawRequestDTO();
		dto.id = 1L;
		dto.amount = -100;

		// Methode 1 - En 1 ligne
		assertThat(bankService.withdraw(dto).code).isEqualTo("ERR-701");

		// Methode 2- En 2 ligne
		// ServiceResponse serviceResponse = bankService.withdraw(dto);
		// assertThat(serviceResponse.code).isEqualTo("ERR-701");

	}

}
