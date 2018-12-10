package co.springboot.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import co.springboot.model.Booking;

@Entity
@Table(name ="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAccount;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@Length( max = 50)
	@Email(message = "Vous devez entrer un email valide")
	@NotBlank(message = "Vous devez entrer un email")
	private String email;
	
	@Length( min = 6, max = 15)
	@NotBlank(message = "Vous devez entrer un mot de passe")
	private String pwd;
	
	@NotBlank
	private String streetAddress;
	
	@NotBlank
	private String cityName;
	
	@NotNull
	private int postalCode;
	
	@NotBlank
	private String phone;

	@NotBlank
	private String situation;
	
	private char etat;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Booking> bookings;
	
	public Account() {
		
	}

	@Override
	public String toString() {
		return "Account [idAccount=" + idAccount + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", pwd=" + pwd + ", streetAddress=" + streetAddress + ", cityName=" + cityName
				+ ", postalCode=" + postalCode + ", phone=" + phone + ", situation=" + situation + ", etat=" + etat
				+ ", bookings=" + bookings + "]";
	}

	public long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(long idAccount) {
		this.idAccount = idAccount;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public char getEtat() {
		return etat;
	}

	public void setEtat(char etat) {
		this.etat = etat;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	

}
