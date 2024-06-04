import { Component } from '@angular/core';
import { ClienteService } from './cliente.service';
import { Cliente } from './models/Cliente';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'academia_do_gui';
  searchTerm: string = '';

  constructor(private clienteService: ClienteService) {}

  onSearch(event: Event) {
    event.preventDefault(); // Impede a recarga da página
    console.log('Procurando por:', this.searchTerm);
    // Aqui você pode chamar o serviço e passar o searchTerm para a API
    this.clienteService.obterTodos().subscribe(clientes => {
      // Filtra clientes baseado no searchTerm
      const resultados = clientes.filter(cliente => cliente.nome?.includes(this.searchTerm));

      console.log('Resultados da busca:', resultados);
    });
  }
}
