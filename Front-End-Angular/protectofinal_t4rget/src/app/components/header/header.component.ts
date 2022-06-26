import { Component, Injectable, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit {

  constructor(private router: Router, private loginService: LoginService) {
    this.loginService.estadoLogeadoSubject.subscribe(data => {
      this.estaLogeado=data;
    });
  }

  estaLogeado: Boolean | undefined;

  ngOnInit(): void {

  }

  Login(){
    this.router.navigate(['/login']);
  }

  Logout(){
    this.loginService.Logout();
  }

}
