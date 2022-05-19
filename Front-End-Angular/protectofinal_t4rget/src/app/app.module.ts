import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { LogoArgPComponent } from './components/logo-arg-p/logo-arg-p.component';
import { SocialnetComponent } from './components/socialnet/socialnet.component';
import { AcercaDeComponent } from './components/acercaDe/acercaDe.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoArgPComponent,
    SocialnetComponent,
    AcercaDeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
