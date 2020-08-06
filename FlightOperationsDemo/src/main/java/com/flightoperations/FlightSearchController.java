package com.flightoperations;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FlightSearchController {

	@Autowired
	FlightRepository repository;

	@GetMapping("/flights/{sortParameter}")
	public List<Flights> searchFlights(@PathVariable("sortParameter") String sortParameter) {
		return (List<Flights>) repository.findAll(Sort.by(sortParameter).descending());
	}

	@GetMapping("/flights/departure/{departure}/{sortParameter}")
	List<Flights> searchFlightsByDate(@PathVariable("departure") @DateTimeFormat(pattern = "yyyy-MM-dd") Date departure,
			@PathVariable("sortParameter") String sortParameter) {
		return (List<Flights>) repository.findByDepartureAfter(departure, Sort.by(sortParameter).descending());
	}

	@GetMapping("/flights/source/{source}/{sortParameter}")
	List<Flights> searchFlightsBySource(@PathVariable("source") String source,
			@PathVariable("sortParameter") String sortParameter) {
		return (List<Flights>) repository.findBySource(source, Sort.by(sortParameter).descending());
	}

	@GetMapping("/flights/destination/{destination}/{sortParameter}")
	List<Flights> searchFlightsByDestination(@PathVariable("destination") String destination,
			@PathVariable("sortParameter") String sortParameter) {
		return (List<Flights>) repository.findByDestination(destination, Sort.by(sortParameter).descending());
	}

	@GetMapping("/flights/id/{id}")
	public Optional<Flights> searchFlightById(@PathVariable Long id) {
		Optional<Flights> flight = repository.findById(id);
		if (!flight.isPresent())
			throw new FlightNotFoundException("id -" + id);
		return flight;
	}

	@PostMapping("/flights")

	public ResponseEntity<Object> createFlight(@RequestBody Flights flight) {
		Flights savedFlight = repository.save(flight);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id/{id}").buildAndExpand(savedFlight.id)
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/flights/id/{id}")
	public ResponseEntity<Object> deleteFlight(@PathVariable Long id) {
		Optional<Flights> flight = repository.findById(id);
		if (!flight.isPresent())
			throw new FlightNotFoundException("id -" + id);
		else
			repository.deleteById(id);
		return ResponseEntity.noContent().build();

	}

}
