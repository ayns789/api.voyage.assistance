package co.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.springboot.model.Booking;

public interface BookingRepo extends JpaRepository <Booking, Long>{

}
