import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Aptitud } from '../model/aptitud';

@Injectable({
  providedIn: 'root'
})
export class AptitudService {

     private apiServerUrl=environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAptitud():Observable<Aptitud[]> {
    return this.http.get<Aptitud[]>(`${this.apiServerUrl}/aptitud/all`);
  }

  public addAptitud(aptitud: Aptitud):Observable<Aptitud>{
    return this.http.post<Aptitud>(`${this.apiServerUrl}/aptitud/add`,aptitud);
  }

  public updateAptitud(aptitud:Aptitud):Observable<Aptitud>{
    return this.http.put<Aptitud>(`${this.apiServerUrl}/aptitud/update`,aptitud);
  }

  public deleteAptitud(aptitudId:number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/aptitud/delete/${aptitudId}`);
  }
}
