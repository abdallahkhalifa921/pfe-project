package com.machine.hub.service;

import com.machine.hub.domain.Machine;
import com.machine.hub.repository.MachineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachineService {

    private final MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }


    // Create (Save)
    public Machine saveMachine(Machine machine) {
        return machineRepository.save(machine);
    }

    // Read (FindAll, FindById)

    public List<Machine> findAllMachines() {
        return machineRepository.findAll();
    }

    public Machine findById(Long id) {
        return machineRepository.findById(id).orElse(null); // Optional handling for null case
    }

    // Update
    public Machine updateMachine(Machine machine) {
        Machine existingMachine = findById(machine.getId());
        if (existingMachine == null) {
            // Handle non-existent machine (e.g., throw exception)
            return null;
        }

        // Update relevant attributes based on received data
        existingMachine.setName(machine.getName());
        existingMachine.setType(machine.getType());
        existingMachine.setModel(machine.getModel());
        existingMachine.setBrand(machine.getBrand());
        existingMachine.setSerialNumber(machine.getSerialNumber());
        existingMachine.setAcquisitionDate(machine.getAcquisitionDate()); // Assuming it's a valid Date object
        existingMachine.setLocation(machine.getLocation());
        existingMachine.setStatus(machine.getStatus());

        // Update optional attributes if provided in the request
        existingMachine.setOperatingSystem(machine.getOperatingSystem());
        existingMachine.setProcessor(machine.getProcessor());
        existingMachine.setRam(machine.getRam());
        existingMachine.setStorage(machine.getStorage());
        existingMachine.setIpAddress(machine.getIpAddress());
        existingMachine.setIdlePowerConsumption(machine.getIdlePowerConsumption());
        existingMachine.setActivePowerConsumption(machine.getActivePowerConsumption());
        existingMachine.setPeakPowerConsumption(machine.getPeakPowerConsumption());
        existingMachine.setPowerUnit(machine.getPowerUnit());
        existingMachine.setLastMaintenanceDate(machine.getLastMaintenanceDate()); // Assuming it's a valid Date object
        existingMachine.setNextMaintenanceDate(machine.getNextMaintenanceDate()); // Assuming it's a valid Date object
        existingMachine.setMaintenanceHistory(machine.getMaintenanceHistory());
        existingMachine.setWarranty(machine.getWarranty());

        return machineRepository.save(existingMachine);
    }

    // Delete
    public void deleteMachine(Long id) {
        machineRepository.deleteById(id);
    }
}
