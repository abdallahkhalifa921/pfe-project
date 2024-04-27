import { Component, OnInit } from '@angular/core';
import { Machine } from 'src/app/model/machine.model';
import { MachineService } from 'src/app/services/machine.service';

@Component({
  selector: 'app-machine',
  templateUrl: './machine.component.html',
  styleUrls: ['./machine.component.css']
})
export class MachineComponent implements OnInit {

  machines: Machine[] = []; // Array to store the fetched machines

  constructor(private machineService: MachineService) { }

  ngOnInit(): void {
    this.fetchMachines(); // Call the fetchMachines() method on init
  }

  fetchMachines(): void {
    this.machineService.getAllMachines()
      .subscribe(machines => this.machines = machines); // Subscribe to the Observable and update the machines array
  }
}
