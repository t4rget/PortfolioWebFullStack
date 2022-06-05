import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PortfolioComponent} from './components/portfolio/portfolio.component';
import { LoginComponent } from './components/login/login.component';
import { SettingComponent } from './components/setting/setting.component';
import { GuardGuard } from './service/guard.guard';


const routes: Routes = [
  {path: 'portfolio',component:PortfolioComponent/*, canActivate:[GuardGuard]*/},
  {path: 'login',component:LoginComponent},
  {path: 'setting',component:SettingComponent},
  {path: '',redirectTo:'portfolio', pathMatch:'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
