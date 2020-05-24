package com.capgemini.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.WalletAccount;



@Repository
public interface WalletAccountDao extends JpaRepository<WalletAccount, Integer> {

}