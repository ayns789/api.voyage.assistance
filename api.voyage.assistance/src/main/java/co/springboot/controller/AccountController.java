package co.springboot.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.springboot.model.Account;
import co.springboot.service.AccountServ;

// @RestController marque la classe en tant que contrôleur dans lequel chaque méthode renvoie un objet de domaine 
//au lieu d'une vue. En annotant une classe avec cette annotation, il n'est plus nécessaire d'ajouter @ResponseBody 
//à toutes les méthodes RequestMapping. Cela signifie que vous n'utilisez plus les résolveurs de vues et n'envoyez pas 
//de HTML en réponse. Vous envoyez simplement l'objet de domaine sous forme de réponse HTTP dans un format compris par les 
//consommateurs, comme JSON.
@RestController
// @RequestMapping : annotation qui garantit que les demandes HTTP à "/api/user"
// sont mappées ici à la classe
// annotation qui peut etre appliquée aux champs, aux méthodes, et aux
// constructeurs
@RequestMapping("/api/user")
public class AccountController {

	// @Autowired indique à Spring d'injecter un objet dans un autre lorsqu'il
	// charge le contexte de l'application. On ne voit uniquement 
	@Autowired
	private AccountServ accountServ;
	
	public AccountController(AccountServ accountServ) {
		this.accountServ = accountServ;
	}

	// @CrossOrigin : partage de ressources d'origines croisées
	@CrossOrigin
	// @GetMapping : utilisé pour mapper des demandes HTTP GET sur des méthodes de
	// gestionnaire spécifiques
	@GetMapping("/users")
	List<Account> getAllUser() {
		return accountServ.getUsers();
	}

	@CrossOrigin
	@GetMapping("/user/{idUser}")
	ResponseEntity<Account> getUserById(@PathVariable(value = "idUser") long idAccount) {
		return accountServ.getUserById(idAccount);
	}

	@CrossOrigin
	// @PostMapping : utilisé pour mapper des demandes HTTP POST sur des méthodes de
	// gestionnaire spécifiques
	@PostMapping("/adduser")
	// @RequestBody indique qu'un paramètre de méthode doit être lié à la valeur du
	// corps de la requête HTTP.
	Account addUser(@Valid @RequestBody Account account) {
		return accountServ.saveAccount(account);
	}
	
	@CrossOrigin
	@PutMapping("/user/{idUpdate}")
	ResponseEntity<Account> updateUser(@PathVariable(value = "idUpdate") long idAccount,
			@Valid @RequestBody Account account) {
		return accountServ.updateAccount(idAccount, account);
	}

	@CrossOrigin
	@DeleteMapping("/user/{idDelete}")
	ResponseEntity<Account> deleteUser(@PathVariable(value = "idDelete") long idAccount) {
		return accountServ.deleteAccount(idAccount);
	}

}
