package com.capgemini.daos;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.entities.WalletUser;

@Repository
public interface WalletUserDao extends JpaRepository<WalletUser, Integer> {
//	@Query("select d from WalletUser d  where user_id =?1 and user_password=?2")
//	WalletUser LoginDetails(Integer userId, String password);
	@Query("select d from WalletUser d  where d.username =:username")
	Optional<WalletUser> LoginDetails(@Param("username") String userName);
}
