import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Persona } from '../model/persona'

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private apiServerUrl='https://appportfolioback.herokuapp.com';

  constructor(private http: HttpClient) { }

  public getPersona():Observable<Persona> {
    return this.http.get<Persona>(`${this.apiServerUrl}/api/persona/id/1`);
  }

  public addPersona(persona: Persona):Observable<Persona>{
    return this.http.post<Persona>(`${this.apiServerUrl}/api/persona/add`,persona);
  }

  public updatePersona(persona:Persona):Observable<Persona>{
    return this.http.put<Persona>(`${this.apiServerUrl}/api/persona`,persona);
  }

  public deletePersona(personaId:number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/persona/delete/${personaId}`);
  }

}
