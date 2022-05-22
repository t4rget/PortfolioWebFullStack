import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LogoArgPComponent } from './components/logo-arg-p/logo-arg-p.component';
import { SocialnetComponent } from './components/socialnet/socialnet.component';
import { AcercaDeComponent } from './components/acercaDe/acercaDe.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
//  Importar ng-circle-progreso
import { NgCircleProgressModule } from 'ng-circle-progress';
import { HyssComponent } from './components/hyss/hyss.component';
import { EducacionComponent } from './components/educacion/educacion.component';
import { ProyectosComponent } from './components/proyectos/proyectos.component';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { IniciarSesionComponent } from './components/iniciar-sesion/iniciar-sesion.component';
import { PortfolioComponent } from './components/portfolio/portfolio.component';
import { ReactiveFormsModule } from '@angular/forms'

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoArgPComponent,
    SocialnetComponent,
    AcercaDeComponent,
    ExperienciaComponent,
    HyssComponent,
    EducacionComponent,
    ProyectosComponent,
    FooterComponent,
    IniciarSesionComponent,
    PortfolioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    //  Especificar ng-circle-progress como una importación
    NgCircleProgressModule.forRoot({}),
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
