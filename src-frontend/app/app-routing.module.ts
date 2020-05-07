import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { ActualiteComponent } from './actualite/actualite.component';
import { HomeComponent } from './home/home.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { SignupUserComponent } from './signup-user/signup-user.component';
import { ListEquipementsComponent } from './list-equipements/list-equipements.component';


const routes: Routes = [
  {path: 'header', component: HeaderComponent },
  {path: 'actualités', component: ActualiteComponent},
  {path: 'equipements', component: ListEquipementsComponent},
  {path: 'home', component: HomeComponent},
  {path: 'auth/signin', component: LoginUserComponent},
  {path: 'auth/signup', component: SignupUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
