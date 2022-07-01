import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor {

  constructor(private loginService: LoginService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    var currentUser = this.loginService.UsuarioAutenticado;
    //var session = sessionStorage.getItem('currentUser') as unknown as datos;
    //console.log("SESSION LOG", session);
    //if(session && session.accessToken)
    if(currentUser && currentUser.accessToken)
    {
      req=req.clone({
        setHeaders:{
          //Authorization: `Bearer ${session.accessToken}`
          Authorization: `Bearer ${currentUser.accessToken}`
        }
      })
    }
    //console.log("Interceptor esta corriendo" /*+ JSON.stringify(currentUser.accessToken)*/);
    return next.handle(req);
  }
}
export interface datos{
  accessToken: string;
}
