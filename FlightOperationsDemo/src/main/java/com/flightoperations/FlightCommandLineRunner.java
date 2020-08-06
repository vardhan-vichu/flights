package com.flightoperations;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FlightCommandLineRunner implements CommandLineRunner {

	@Autowired
	FlightRepository repository;

	@Override
	public void run(String... args) throws Exception {

		repository.save(new Flights("Indigo", "Chennai", "Delhi", 4500,
				new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("06-08-2020 08:40:00"),
				new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("06-08-2020 10:20:56")));
		repository.save(new Flights("Indigo", "Chennai", "Delhi", 4500,
				new SimpleDateFormat("dd-M-yyyy").parse("05-08-2020 08:40:00"),
				new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("05-08-2020 10:20:56")));
		repository.save(new Flights("Air Asia", "Chennai", "Delhi", 4300,
				new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("06-08-2020 09:40:00"),
				new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("07-08-2020 11:20:56")));
		repository.save(new Flights("Air Asia", "Chennai", "Delhi", 4300,
				new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("07-08-2020 09:40:00"),
				new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("07-08-2020 11:20:56")));
		repository.save(new Flights("Tiger", "Chennai", "Delhi", 4000,
				new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("07-08-2020 04:40:00"),
				new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("07-08-2020 08:20:56")));
		repository.save(new Flights("Indigo", "Chennai", "Bengaluru", 4500,
				new SimpleDateFormat("dd-M-yyyy").parse("05-08-2020 04:40:00"),
				new SimpleDateFormat("dd-M-yyyy").parse("05-08-2020 08:40:00")));
		repository.save(new Flights("Air India", "Chennai", "Bengaluru", 3800,
				new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("05-08-2020 09:40:00"),
				new SimpleDateFormat("dd-M-yyyy hh:mm:ss").parse("06-08-2020 10:20:56")));

	}

}
