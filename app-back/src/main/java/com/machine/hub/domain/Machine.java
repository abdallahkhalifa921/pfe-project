package com.machine.hub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "machines")  // Optional: Specify the table name if different from "machines"
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type; // e.g., "PCB Assembly", "Soldering Station"
    private String model;
    private String brand;
    private String serialNumber;

    // Acquisition details (optional)

    private LocalDateTime acquisitionDate;
    private String location;
    private String status; // e.g., "Operational", "Maintenance", "Faulty"

    // Technical attributes
    private String operatingSystem; // For control PCs or embedded systems
    private String processor;
    private String ram;
    private String storage;
    private String ipAddress; // If applicable

    // Power consumption attributes
    private Double idlePowerConsumption; // Power consumption when idle
    private Double activePowerConsumption; // Power consumption during active operation
    private Double peakPowerConsumption; // Maximum power consumption during peak usage
    private String powerUnit; // Unit of power consumption (e.g., "W", "kW")

    // Maintenance attributes (optional)

    private LocalDateTime lastMaintenanceDate;

    private LocalDateTime nextMaintenanceDate;
    @Lob
    private String maintenanceHistory;
    private String warranty;

}
