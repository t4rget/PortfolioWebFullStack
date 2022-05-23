import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PortfolioComponent} from './components/portfolio/portfolio.component';
import { IniciarSesionComponent } from './components/iniciar-sesion/iniciar-sesion.component';
import { SettingComponent } from './components/setting/setting.component';


const routes: Routes = [
  {path: 'portfolio',component:PortfolioComponent},
  {path: 'iniciar-sesion',component:IniciarSesionComponent},
  {path: 'setting',component:SettingComponent},
  {path: '',redirectTo:'portfolio', pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
