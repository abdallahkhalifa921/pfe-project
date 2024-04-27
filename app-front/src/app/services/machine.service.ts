import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Machine } from '../model/machine.model';

@Injectable({
  providedIn: 'root'
})
export class MachineService {

  constructor(private http: HttpClient) { }

  getAllMachines(): Observable<Machine[]> {
    return this.http.get<Machine[]>(`http://localhost:8080/api/machines`)
      .pipe(map(machines => machines)); // Keep the response structure as is
  }

  getMachineById(id: number): Observable<Machine> {
    return this.http.get<Machine>(`localhost:8080/api/machines/${id}`)
      .pipe(map(machine => machine)); // Keep the response structure as is
  }

  createMachine(machine: Machine): Observable<Machine> {
    return this.http.post<Machine>(`localhost:8080/api/machines`, machine)
      .pipe(map(newMachine => newMachine)); // Keep the response structure as is
  }

  updateMachine(machine: Machine): Observable<Machine> {
    return this.http.put<Machine>(`localhost:8080/api/machines/${machine.id}`, machine)
      .pipe(map(updatedMachine => updatedMachine)); // Keep the response structure as is
  }

  deleteMachine(id: number): Observable<void> {
    return this.http.delete<void>(`localhost:8080/api/machines/${id}`); // No response expected
  }
}
