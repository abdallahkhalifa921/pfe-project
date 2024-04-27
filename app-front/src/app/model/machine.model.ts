import * as moment from 'moment';

export interface Machine {
    id?: number; // Make id optional as it's auto-generated
    name: string;
    type: string; // e.g., "PCB Assembly", "Soldering Station"
    model: string;
    brand: string;
    serialNumber: string;
  
    // Acquisition details (optional)
    acquisitionDate?: moment.Moment;
    location?: string;
    status?: string; // e.g., "Operational", "Maintenance", "Faulty"
  
    // Technical attributes
    operatingSystem?: string; // For control PCs or embedded systems
    processor?: string;
    ram?: string;
    storage?: string;
    ipAddress?: string; // If applicable
  
    // Power consumption attributes
    idlePowerConsumption?: number; // Changed to number for consistency
    activePowerConsumption?: number; // Changed to number for consistency
    peakPowerConsumption?: number; // Changed to number for consistency
    powerUnit?: string; // Unit of power consumption (e.g., "W", "kW")
  
    // Maintenance attributes (optional)
    lastMaintenanceDate?: moment.Moment;
    nextMaintenanceDate?: moment.Moment;
    maintenanceHistory?: string;
    warranty?: string;
  }