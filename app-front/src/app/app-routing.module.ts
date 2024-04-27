import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MachineComponent } from './components/machine/machine.component';

const routes: Routes = [
  {path : "machine" , component : MachineComponent},
  {path : "**", redirectTo: "machine",pathMatch : "full"}
]


@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
