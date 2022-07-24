import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Proyecto } from '../model/proyecto';

@Injectable({
  providedIn: 'root'
})
export class ProyectoService {

  private apiServerUrl='https://appportfolioback.herokuapp.com';

  constructor(private http: HttpClient) { }

  public getProyecto():Observable<Proyecto[]> {
    return this.http.get<Proyecto[]>(`${this.apiServerUrl}/api/proyecto/all`);
  }

  public addProyecto(proyecto: Proyecto):Observable<Proyecto>{
    return this.http.post<Proyecto>(`${this.apiServerUrl}/api/proyecto/add`,proyecto);
  }

  public updateProyecto(proyecto:Proyecto):Observable<Proyecto>{
    return this.http.put<Proyecto>(`${this.apiServerUrl}/api/proyecto/update`,proyecto);
  }

  public deleteProyecto(proyectoId:number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/proyecto/delete/${proyectoId}`);
  }

}
