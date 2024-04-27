package com.machine.hub.controller;

import com.machine.hub.domain.Machine;
import com.machine.hub.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Assuming you have a MachineService class
@RestController
@RequestMapping("/api/machines") // All endpoints related to machines
public class MachineController {

    private final MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    // Get All Machines (Read)
    @GetMapping
    public ResponseEntity<List<Machine>> getAllMachines() {
        return ResponseEntity.ok(machineService.findAllMachines());
    }

    // Get Machine by ID (Read)
    @GetMapping("/{id}")
    public ResponseEntity<Machine> getMachineById(@PathVariable Long id) {
        Machine machine = machineService.findById(id);
        return machine != null ? ResponseEntity.ok(machine) : ResponseEntity.notFound().build();
    }

    // Create Machine (Create)
    @PostMapping
    public ResponseEntity<Machine> createMachine(@RequestBody Machine machine) {
        Machine savedMachine = machineService.saveMachine(machine);
        return ResponseEntity.ok(savedMachine);
    }

    // Update Machine (Update)
    @PutMapping("/{id}")
    public ResponseEntity<Machine> updateMachine(@PathVariable Long id, @RequestBody Machine machine) {
        machine.setId(id); // Set ID to ensure proper update
        Machine updatedMachine = machineService.updateMachine(machine);
        return updatedMachine != null ? ResponseEntity.ok(updatedMachine) : ResponseEntity.notFound().build();
    }

    // Delete Machine (Delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachine(@PathVariable Long id) {
        machineService.deleteMachine(id);
        return ResponseEntity.noContent().build();
    }
}
