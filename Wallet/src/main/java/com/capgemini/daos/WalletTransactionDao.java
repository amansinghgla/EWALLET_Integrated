package com.capgemini.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.WalletTransaction;


@Repository
public interface WalletTransactionDao extends JpaRepository<WalletTransaction, Integer> {
	List<WalletTransaction> findBySenderAccId(int senderAccId);

}