import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { ActualiteComponent } from './actualite/actualite.component';
import { HomeComponent } from './home/home.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { SignupUserComponent } from './signup-user/signup-user.component';
import { ListEquipementsComponent } from './list-equipements/list-equipements.component';
import { DemandeComponent } from './demande/demande.component';
import { AuthGuardService } from './services/auth-guard.service';
import { DemandesComponent } from './gestionnaires/demandes/demandes.component';
import { ReservationsComponent } from './gestionnaires/reservations/reservations.component';
import { AutorisationsComponent } from './gestionnaires/autorisations/autorisations.component';
import { DemandeUnitComponent } from './demande/demande-unit/demande-unit.component';
import { DemandeFormulaireComponent } from './demande/demande-formulaire/demande-formulaire.component';
import { ReservationUnitComponent } from './gestionnaires/reservations/reservation-unit/reservation-unit.component';
import { AutorisationUnitComponent } from './autorisations/autorisation-unit/autorisation-unit.component';


const routes: Routes = [
  {path: 'view', component: DemandeUnitComponent},
  {path: 'mesDemandes', component: DemandeComponent},
  {path: 'header', component: HeaderComponent },
  {path: 'actualite', component: ActualiteComponent},
  {path: 'equipements', component: ListEquipementsComponent},
  {path: 'home', component: HomeComponent},
  {path: 'auth/signin', component: LoginUserComponent},
  {path: 'auth/signup', component: SignupUserComponent},
  {path: 'AddDemande' , canActivate: [AuthGuardService], component: DemandeFormulaireComponent},
  {path: 'demandes', canActivate: [AuthGuardService], component: DemandesComponent},
  {path: 'AllDemandes', canActivate: [AuthGuardService], component: DemandesComponent},
  {path: 'AllReservations', canActivate: [AuthGuardService], component: ReservationsComponent},
  {path: 'AllAutorisations', canActivate: [AuthGuardService], component: AutorisationsComponent},
  {path: 'AllReservations/:id', canActivate: [AuthGuardService], component: ReservationUnitComponent},
  {path: 'AllAutorisations/:id', canActivate: [AuthGuardService], component: AutorisationUnitComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
