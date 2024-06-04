import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FrmClienteComponent } from './Cliente/frm-cliente/frm-cliente.component';
import { LstClienteComponent } from './Cliente/lst-cliente/lst-cliente.component';
import { UptClienteComponent } from './Cliente/upt-cliente/upt-cliente.component';

const routes: Routes = [
  {path: '', component: LstClienteComponent},
  {path: 'register-cliente', component: FrmClienteComponent},
  {path: 'update-cliente/:id', component: UptClienteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
