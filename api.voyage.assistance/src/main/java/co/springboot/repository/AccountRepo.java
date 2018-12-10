package co.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.springboot.model.Account;

public interface AccountRepo extends JpaRepository <Account, Long> {


}
