import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { ActualiteComponent } from './actualite/actualite.component';
import { HomeComponent } from './home/home.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { SignupUserComponent } from './signup-user/signup-user.component';
import { ListEquipementsComponent } from './list-equipements/list-equipements.component';
import { DemandeComponent } from './demandeur/demande/demande.component';
import { AuthGuardService } from './services/auth-guard.service';
import { DemandesComponent } from './gestionnaires/demandes/demandes.component';
import { ReservationsComponent } from './gestionnaires/reservations/reservations.component';
import { AutorisationsComponent } from './gestionnaires/autorisations/autorisations.component';
import { DemandeUnitComponent } from './demandeur/demande/demande-unit/demande-unit.component';
import { DemandeFormulaireComponent } from './demandeur/demande/demande-formulaire/demande-formulaire.component';
import { ReservationUnitComponent } from './gestionnaires/reservations/reservation-unit/reservation-unit.component';
import { AutorisationUnitComponent } from './gestionnaires/autorisations/autorisation-unit/autorisation-unit.component';
import { ProfileComponent } from './gestionnaires/profile/profile.component';
import { DemandeurProfileComponent } from './demandeur/demandeur-profile/demandeur-profile.component';
import { AuthenticationComponent } from './gestionnaires/authentication/authentication.component';
import { DemandeursComponent } from './gestionnaires/demandeurs/demandeurs.component';
import { DemandeurUnitComponent } from './gestionnaires/demandeurs/demandeur-unit/demandeur-unit.component';
import { ListDemandesComponent } from './gestionnaires/demandeurs/list-demandes/list-demandes.component';
import { DemandeViewComponent } from './gestionnaires/demandeurs/list-demandes/demande-view/demande-view.component';
import { ViewFileComponent } from './gestionnaires/demandeurs/demandeur-unit/view-file/view-file.component';
import { DemandeDetailComponent } from './demandeur/demande/demande-detail/demande-detail.component';
import { EquipementUpdateComponent } from './list-equipements/equipement-update/equipement-update.component';
import { EquipementCreateComponent } from './list-equipements/equipement-create/equipement-create.component';
import { SignUpGestionnaireComponent } from './gestionnaires/sign-up-gestionnaire/sign-up-gestionnaire.component';
import { AutorisationChartComponent } from './decideur/autorisation-chart/autorisation-chart.component';
import { AutorisationEquipementComponent } from './decideur/autorisation-chart/autorisation-equipement/autorisation-equipement.component';
// tslint:disable-next-line: max-line-length
import { AutorisationGestionnaireComponent } from './decideur/autorisation-chart/autorisation-gestionnaire/autorisation-gestionnaire.component';
import { DemandesChartComponent } from './decideur/demandes-chart/demandes-chart.component';
import { DemandesDemandeurComponent } from './decideur/demandes-chart/demandes-demandeur/demandes-demandeur.component';
import { DemandesViewComponent } from './decideur/demandes-chart/demandes-view/demandes-view.component';
import { AutorisationsViewComponent } from './decideur/autorisation-chart/autorisations-view/autorisations-view.component';
import { ProfilViewComponent } from './gestionnaires/profile/profil-view/profil-view.component';
import { ProfileViewComponent } from './demandeur/demandeur-profile/profile-view/profile-view.component';




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
  {path: 'AllAutorisations/:id', canActivate: [AuthGuardService], component: AutorisationUnitComponent},
  {path: 'gestionnaire/profile', canActivate: [AuthGuardService], component: ProfileComponent},
  {path: 'demandeurProfile', canActivate: [AuthGuardService], component: DemandeurProfileComponent},
  {path: 'admin/auth', component: AuthenticationComponent},
  {path: 'demandeurs', component: DemandeursComponent, canActivate: [AuthGuardService]},
  {path: 'demandeurs/:id', canActivate: [AuthGuardService], component: DemandeurUnitComponent},
  {path: 'demandeur/list-demandes/:id', canActivate: [AuthGuardService], component: ListDemandesComponent},
  {path: 'demandeur/demande/:id', canActivate: [AuthGuardService], component: DemandeViewComponent},
  {path: 'demandeur/view_file/:id', canActivate: [AuthGuardService], component: ViewFileComponent},
  {path: 'mesDemandes/demande_detail/:id', canActivate: [AuthGuardService], component: DemandeDetailComponent},
  {path: 'equipements/update/:id', canActivate: [AuthGuardService], component: EquipementUpdateComponent},
  {path: 'equipements/addEquipement', canActivate: [AuthGuardService], component: EquipementCreateComponent},
  {path: 'auth/division/signup', component: SignUpGestionnaireComponent},
  {path: 'decideurs/autorisations-totales', canActivate: [AuthGuardService], component: AutorisationChartComponent},
  {path: 'decideurs/autorisations/equipement', canActivate: [AuthGuardService], component: AutorisationEquipementComponent},
  {path: 'decideurs/autorisations/gestionnaire', canActivate: [AuthGuardService], component: AutorisationGestionnaireComponent},
  {path: 'decideurs/autorisations', canActivate: [AuthGuardService], component: AutorisationsViewComponent},
  {path: 'demandeur/profile/view', canActivate: [AuthGuardService], component: ProfileViewComponent},
  {path: 'decideurs/demandes-totales', canActivate: [AuthGuardService], component: DemandesChartComponent},
  {path: 'decideurs/demandes', canActivate: [AuthGuardService], component: DemandesViewComponent},
  {path: 'decideurs/demandes/demandeur', canActivate: [AuthGuardService], component: DemandesDemandeurComponent},
  {path: 'gestionnaire/profile-view', canActivate: [AuthGuardService], component: ProfilViewComponent},
  {path: '', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
