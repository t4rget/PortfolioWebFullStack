import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, from, map, Observable, switchMap } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { datos } from './interceptor.service';


@Injectable({
  providedIn: 'root'
})
export class LoginService {


  url = "http://localhost:8080/api/login";
  currentUserSubject: BehaviorSubject<any>;
  estadoLogeadoSubject: BehaviorSubject<boolean>;

  constructor(private http: HttpClient) {
    this.estadoLogeadoSubject= new BehaviorSubject<boolean>(false);
    console.log("el servicio de autenticacion esta en espera/corriendo");
    this.currentUserSubject=new BehaviorSubject<any>(JSON.parse(sessionStorage.getItem('currentUser')||'{}'));
    this.currentUserSubject.subscribe(user => {
    this.estadoLogeadoSubject.next(user && user.accessToken);
    })

  }

  Login(credenciales:any):Observable<any> {
    return this.http.post(this.url, credenciales).pipe(map(data=>{
      sessionStorage.setItem('currentUser', JSON.stringify(data));
      this.currentUserSubject.next(data);
      this.estadoLogeadoSubject.next(true);
        return data;
    }))
  }

  Logout(): void {
    sessionStorage.removeItem('currentUser');
    this.currentUserSubject.next({});
    console.log("logout")
    this.estadoLogeadoSubject.next(false);
  }

  get UsuarioAutenticado() {
    return this.currentUserSubject.value;
    console.log("VALUE", this.currentUserSubject.value)
  }

  estaLogeado(): Boolean {
    return this.estadoLogeadoSubject.value;


  }

}
