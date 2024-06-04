import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from './models/Cliente';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private urlApi = 'http://localhost:8080/api/clientes';

  constructor(private http: HttpClient) { }

  public inserir(cliente: Cliente): Observable<boolean> {
    return this.http.post<boolean>(this.urlApi, cliente);
  }

  public alterar(id: number, cliente: Cliente): Observable<boolean> {
    return this.http.put<boolean>(`${this.urlApi}/${id}`, cliente);
  }

  public deletar(id: number): Observable<boolean> {
    return this.http.delete<boolean>(`${this.urlApi}/${id}`);
  }

  public obterPorId(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.urlApi}/${id}`);
  }

  public obterTodos(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.urlApi);
  }

  
}
