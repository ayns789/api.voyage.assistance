package co.springboot.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import co.springboot.model.Account;
import co.springboot.model.Places;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idBooking;
	
	@DateTimeFormat
	private Date dateBooking;
	
	@DateTimeFormat
	private Date dateEarlyBooking;
	
	@DateTimeFormat
	private Date dateEndBooking;
	
	public Booking () {
		
	}
	
	@ManyToOne
	private Account account;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
    private Set<Places> places;
        
	@Override
	public String toString() {
		return "Booking [idBooking=" + idBooking + ", dateBooking=" + dateBooking + ", dateEarlyBooking="
				+ dateEarlyBooking + ", dateEndBooking=" + dateEndBooking + ", account=" + account + ", places="
				+ places + "]";
	}

	public long getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(long idBooking) {
		this.idBooking = idBooking;
	}

	public Date getDateBooking() {
		return dateBooking;
	}

	public void setDateBooking(Date dateBooking) {
		this.dateBooking = dateBooking;
	}

	public Date getDateEarlyBooking() {
		return dateEarlyBooking;
	}

	public void setDateEarlyBooking(Date dateEarlyBooking) {
		this.dateEarlyBooking = dateEarlyBooking;
	}

	public Date getDateEndBooking() {
		return dateEndBooking;
	}

	public void setDateEndBooking(Date dateEndBooking) {
		this.dateEndBooking = dateEndBooking;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Places> getPlaces() {
		return places;
	}

	public void setPlaces(Set<Places> places) {
		this.places = places;
	}

	
	
	

}
