package com.flightoperations;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flights, Long> {
	List<Flights> findAll(Sort sort);

	List<Flights> findByDepartureAfter(Date departure, Sort sort);

	List<Flights> findBySource(String source, Sort sort);

	List<Flights> findByDestination(String destination, Sort sort);
}
