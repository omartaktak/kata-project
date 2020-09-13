package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	
	@Query("select tc from Transaction  tc where ac.idAccount = ?1")
	List<Transaction> getTransactionsByIdAccount(String idAcoount);
}
