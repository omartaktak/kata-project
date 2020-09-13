package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTest {

	MockMvc mvc;
	
	@Mock
	TransactionRepository transactionRepository;
	
	@InjectMocks
	TransactionController controller;
	
	Transaction transaction;
	
	List<Transaction> transactionList;
	
	/**
	 * This method will initialise the objects rquired in the method of test  
	 */
	@Before
	public void init() {
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		transaction= new Transaction();
		transaction.setIdAccount("ACCOUNT1");
		
		transactionList = new ArrayList<>();
		transactionList.add(transaction);
	}
	
	/**
	 * This method will test the depositMoney controller  
	 */
	@Test
	public void depositMoneyTest() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		when(transactionRepository.save(any())).thenReturn(transaction);
		mvc.perform(post("/transaction/depositMoney")
			.contentType(MediaType.APPLICATION_JSON)
			.content(mapper.writeValueAsBytes(transaction)))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.idAccount", is("ACCOUNT1")));
	}
	
	/**
	 * This method will test the withdrawMoney controller  
	 */
	@Test
	public void withdrawMoneyTest() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		when(transactionRepository.save(any())).thenReturn(transaction);
		mvc.perform(post("/transaction/withdrawMoney")
			.contentType(MediaType.APPLICATION_JSON)
			.content(mapper.writeValueAsBytes(transaction)))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.idAccount", is("ACCOUNT1")));
	}
	
	/**
	 * This method will test the getAllCoherenceAlertes controller  
	 */
	@Test
	public void getAllCoherenceAlertes() throws Exception {
		
		when(transactionRepository.getTransactionsByIdAccount(anyString())).thenReturn(transactionList);
		mvc.perform(get("/transaction/find/list/transaction/ACCOUNT1",1)).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].idAccount", is("ACCOUNT1")));
		
	}
}
