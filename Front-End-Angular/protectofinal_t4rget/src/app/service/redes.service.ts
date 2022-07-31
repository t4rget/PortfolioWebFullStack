import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Redes } from '../model/redes';

@Injectable({
  providedIn: 'root'
})
export class RedesService {

  private apiServerUrl='https://app-portfolio-ap.herokuapp.com';

  constructor(private http: HttpClient) { }

  public getRedes():Observable<Redes[]> {
    return this.http.get<Redes[]>(`${this.apiServerUrl}/api/redes/`);
  }

  public addRedes(redes: Redes):Observable<Redes>{
    return this.http.post<Redes>(`${this.apiServerUrl}/api/redes/`,redes);
  }

  public updateRedes(redes:Redes):Observable<Redes>{
    return this.http.put<Redes>(`${this.apiServerUrl}/api/redes/`,redes);
  }

  public deleteRedes(redesId:number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/redes/${redesId}`);
  }

}
