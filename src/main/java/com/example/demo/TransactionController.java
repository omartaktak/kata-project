package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionRepository transactionRepository;
	
	@PostMapping(value = "/depositMoney")
	public ResponseEntity<Transaction> depositMoney(@RequestBody Transaction transaction) {

		Transaction trans = transactionRepository.save(transaction);
		return new ResponseEntity<>(trans, HttpStatus.OK);
	}
	
	@PostMapping(value = "/withdrawMoney")
	public ResponseEntity<Transaction> withdrawMoney(@RequestBody Transaction transaction) {

		Transaction trans = transactionRepository.save(transaction);
		return new ResponseEntity<>(trans, HttpStatus.OK);
	}
	
	@GetMapping(value = "/find/list/transaction/{idAccount}")
	public ResponseEntity<List<Transaction>> getTransactionsByIdAccount(@PathVariable("idAccount")String type) {

		List<Transaction> trans = transactionRepository.getTransactionsByIdAccount(type);
		return new ResponseEntity<>(trans, HttpStatus.OK);
	}
}
