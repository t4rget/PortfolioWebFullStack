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
import { NgCircleProgressModule } from 'ng-circle-progress'      ;

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoArgPComponent,
    SocialnetComponent,
    AcercaDeComponent,
    ExperienciaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    //  Especificar ng-circle-progress como una importación
    NgCircleProgressModule.forRoot({}),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
