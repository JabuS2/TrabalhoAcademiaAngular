import { Component } from '@angular/core';
import { Cliente } from '../../models/Cliente';
import { ClienteService } from '../../cliente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-frm-cliente',
  templateUrl: './frm-cliente.component.html',
  styleUrls: ['./frm-cliente.component.css']
})
export class FrmClienteComponent {
  cliente: Cliente = {};

  constructor(private service: ClienteService, private router: Router) {}

  submitForm() {
    this.service.inserir(this.cliente).subscribe({
      next: () => {
        alert('Usuário criado com sucesso');
        this.router.navigate(['/']);
      },
      error: (err) => {
        console.error('Erro ao criar usuário:', err);
        alert('Ocorreu um erro ao criar o usuário');
      }
    });
  }
}
