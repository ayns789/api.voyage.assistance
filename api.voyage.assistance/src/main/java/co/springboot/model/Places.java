package co.springboot.model;


import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import co.springboot.enumeration.Activities;
import co.springboot.enumeration.Services;
import co.springboot.model.Booking;

@Entity
@Table(name = "places")
public class Places {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPlace;
	
	@NotBlank
	private String streetAddress;
	
	@NotNull
	private int postalCode;
	
	@NotBlank
	private String cityName;
	
	@NotBlank
	private String phone;
	
	@NotNull
	private boolean capacity;
	
	@Enumerated(EnumType.STRING)
    private Activities activities;
	
	@Enumerated(EnumType.STRING)
    private Services services;
	
	@ManyToMany(mappedBy = "places")
	private Set<Booking> bookings;
	
	public Places() {
		
	}
	
	@Override
	public String toString() {
		return "Places [idPlace=" + idPlace + ", streetAddress=" + streetAddress + ", postalCode=" + postalCode
				+ ", cityName=" + cityName + ", phone=" + phone + ", capacity=" + capacity + ", activities="
				+ activities + ", services=" + services + ", bookings=" + bookings + "]";
	}

	public int getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(int idPlace) {
		this.idPlace = idPlace;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isCapacity() {
		return capacity;
	}

	public void setCapacity(boolean capacity) {
		this.capacity = capacity;
	}

	public Activities getActivities() {
		return activities;
	}

	public void setActivities(Activities activities) {
		this.activities = activities;
	}

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	


}
