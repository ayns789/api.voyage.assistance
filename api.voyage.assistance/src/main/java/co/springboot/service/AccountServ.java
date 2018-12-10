package co.springboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import co.springboot.model.Account;
import co.springboot.repository.AccountRepo;


@Service
public class AccountServ {
	
	@Autowired
	AccountRepo accountRepo;
	
//	BookingRepo bookingRepo;
	
	public AccountServ (AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}
	

	
	public ResponseEntity<Account> deleteAccount (long idAccount) {
		Account account = accountRepo.findOne(idAccount);
		if (account == null) {
			return ResponseEntity.notFound().build();
		}
		accountRepo.delete(account);
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<Account> getUserById (long idAccount) {
	Account account = accountRepo.findOne(idAccount);
	if (account == null) {
		return ResponseEntity.notFound().build();
	}
	return ResponseEntity.ok().body(account);
	}
	
	public List<Account> getUsers(){
	return accountRepo.findAll();
	}
	
	public Account saveAccount(Account account) {
	return accountRepo.save(account);
	}
	
//	public Account saveBookings(Account account, List<Booking> bookings) {
//		return accountRepo.save(account, bookings);
//		}
	
	public ResponseEntity<Account> updateAccount (long idAccount, Account account) {
	Account userToUpdate = accountRepo.findOne(idAccount);
	if (userToUpdate == null)
		return ResponseEntity.notFound().build();

	userToUpdate.setFirstName(account.getFirstName());
	userToUpdate.setLastName(account.getLastName());

	if (account.getEmail() != null)
		userToUpdate.setEmail(account.getEmail());
	
	if (account.getStreetAddress() != null)
		userToUpdate.setStreetAddress(account.getStreetAddress());

	if (account.getCityName() != null)
		userToUpdate.setCityName(account.getCityName());

	if (account.getPostalCode() > 0)
		userToUpdate.setPostalCode(account.getPostalCode());

	if (account.getPhone() != null)
		userToUpdate.setPhone(account.getPhone());

	Account updatedUser = accountRepo.save(userToUpdate);
	return ResponseEntity.ok(updatedUser);
	
}

}
