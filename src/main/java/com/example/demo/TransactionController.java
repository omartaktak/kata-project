package com.example.demo;

import java.util.List;

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

	@PostMapping(value = "/depositMoney")
	public ResponseEntity<Transaction> depositMoney(@RequestBody Transaction transaction) {

		return null;
	}
	
	@PostMapping(value = "/withdrawMoney")
	public ResponseEntity<Transaction> withdrawMoney(@RequestBody Transaction transaction) {

		return null;
	}
	
	@GetMapping(value = "/find/list/transaction/{idAccount}")
	public ResponseEntity<List<Transaction>> getTransactionsByIdAccount(@PathVariable("idAccount")String type) {

		return null;
	}
}
