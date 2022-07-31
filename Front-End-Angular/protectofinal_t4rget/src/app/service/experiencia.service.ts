import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Experiencia } from '../model/experiencia';

@Injectable({
  providedIn: 'root'
})
export class ExperienciaService {

  private apiServerUrl='https://app-portfolio-ap.herokuapp.com';

  constructor(private http: HttpClient) { }

  public getExperiencia():Observable<Experiencia[]> {
    return this.http.get<Experiencia[]>(`${this.apiServerUrl}/api/experiencia/all`);
  }

  public addExperiencia(experiencia: Experiencia):Observable<Experiencia>{
    return this.http.post<Experiencia>(`${this.apiServerUrl}/api/experiencia/add`,experiencia);
  }

  public updateExperiencia(experiencia:Experiencia):Observable<Experiencia>{
    return this.http.put<Experiencia>(`${this.apiServerUrl}/api/experiencia/update`,experiencia);
  }

  public deleteExperiencia(experienciaId:number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/experiencia/delete/${experienciaId}`);
  }
}
