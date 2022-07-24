import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Aptitud } from '../model/aptitud';

@Injectable({
  providedIn: 'root'
})
export class AptitudService {

     private apiServerUrl='https://appportfolioback.herokuapp.com';

  constructor(private http: HttpClient) { }

  public getAptitud():Observable<Aptitud[]> {
    return this.http.get<Aptitud[]>(`${this.apiServerUrl}/api/aptitud/all`);
  }

  public addAptitud(aptitud: Aptitud):Observable<Aptitud>{
    return this.http.post<Aptitud>(`${this.apiServerUrl}/api/aptitud/add`,aptitud);
  }

  public updateAptitud(aptitud:Aptitud):Observable<Aptitud>{
    return this.http.put<Aptitud>(`${this.apiServerUrl}/api/aptitud/update`,aptitud);
  }

  public deleteAptitud(aptitudId:number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/aptitud/delete/${aptitudId}`);
  }
}
