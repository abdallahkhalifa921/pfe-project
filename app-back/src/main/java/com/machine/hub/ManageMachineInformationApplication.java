package com.machine.hub;

import com.machine.hub.domain.Machine;
import com.github.javafaker.Faker; // Add this dependency

import com.machine.hub.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ManageMachineInformationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ManageMachineInformationApplication.class, args);
	}
	@Autowired
	private MachineRepository machineRepository;

	@Override
	public void run(String... args) throws Exception {
		int numberOfMachines = 3; // Adjust this to create the desired number of machines
		List<Machine> machines = new ArrayList<>();

		for (int i = 0; i < numberOfMachines; i++) {
			Machine machine = new Machine();

			// Set attributes with pre-defined values
			machine.setName("Machine " + (i + 1));
			machine.setType("PCB Assembly"); // Adjust type as needed
			machine.setModel("Model XYZ-" + (i + 1));
			machine.setBrand("ACME Corp");
			machine.setSerialNumber("SN-" + String.format("%05d", i + 1)); // Formatted serial number

			// Set specific dates (optional)
			machine.setAcquisitionDate(LocalDateTime.now()); // Adjust date

			// Set location (optional)
			machine.setLocation("Factory Floor 2");

			// Set status
			machine.setStatus("Operational");

			// ... (Set other attributes with pre-defined values as needed)

			machines.add(machine);
		}

		// Save all machines using machineRepository (assuming it's injected)
		machineRepository.saveAll(machines);

		System.out.println("Successfully created and saved " + numberOfMachines + " machines!");
	}
}
