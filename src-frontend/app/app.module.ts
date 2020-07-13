import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {ButtonModule} from 'primeng/button';
import {Component, ViewEncapsulation} from '@angular/core';
import {trigger, state, style, transition, animate, AnimationEvent} from '@angular/animations';
import {FormsModule, ReactiveFormsModule, FormGroup} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {DataViewModule} from 'primeng/dataview';
import {DropdownModule} from 'primeng/dropdown';
import {PanelModule} from 'primeng/panel';
import {DialogModule} from 'primeng/dialog';
import { JwtHelperService } from '@auth0/angular-jwt';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ActualiteComponent } from './actualite/actualite.component';
import { HomeComponent } from './home/home.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { SignupUserComponent } from './signup-user/signup-user.component';
import { AuthService } from './services/auth.service';
import { ListEquipementsComponent } from './list-equipements/list-equipements.component';
import { EquipementsService } from './services/equipements.service';
import { EquipementSumComponent } from './list-equipements/equipement-sum/equipement-sum.component';
import { EquipementDetailComponent } from './list-equipements/equipement-detail/equipement-detail.component';
import { DemandeComponent } from './demandeur/demande/demande.component';
import { AuthGuardService } from './services/auth-guard.service';
import { DemandesComponent } from './gestionnaires/demandes/demandes.component';
import { ReservationsComponent } from './gestionnaires/reservations/reservations.component';
import { AutorisationsComponent } from './gestionnaires/autorisations/autorisations.component';
import { DemandeFormulaireComponent } from './demandeur/demande/demande-formulaire/demande-formulaire.component';
import { DemandeUnitComponent } from './demandeur/demande/demande-unit/demande-unit.component';
import { ReservationViewComponent } from './gestionnaires/reservations/reservation-view/reservation-view.component';
import { DemandeSummaryComponent } from './demandeur/demande/demande-summary/demande-summary.component';
import { ReservationUnitComponent } from './gestionnaires/reservations/reservation-unit/reservation-unit.component';
import { AutorisationUnitComponent } from './gestionnaires/autorisations/autorisation-unit/autorisation-unit.component';
import { FooterComponent } from './footer/footer.component';
import { ProfileComponent } from './gestionnaires/profile/profile.component';
import { DemandeurProfileComponent } from './demandeur/demandeur-profile/demandeur-profile.component';
import { AuthenticationComponent } from './gestionnaires/authentication/authentication.component';
import { DemandeursComponent } from './gestionnaires/demandeurs/demandeurs.component';
import { DemandeurUnitComponent } from './gestionnaires/demandeurs/demandeur-unit/demandeur-unit.component';
import { ListDemandesComponent } from './gestionnaires/demandeurs/list-demandes/list-demandes.component';
import { DemandeViewComponent } from './gestionnaires/demandeurs/list-demandes/demande-view/demande-view.component';
import { PdfViewerModule } from 'ng2-pdf-viewer';
import { ViewFileComponent } from './gestionnaires/demandeurs/demandeur-unit/view-file/view-file.component';
import { ClarityModule } from '@clr/angular';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DemandeDetailComponent } from './demandeur/demande/demande-detail/demande-detail.component';
import { EquipementUpdateComponent } from './list-equipements/equipement-update/equipement-update.component';
import { GoogleMapsModule } from '@angular/google-maps';
import { EquipementCreateComponent } from './list-equipements/equipement-create/equipement-create.component';
import { HttpModule } from '@angular/http';
import { SignUpGestionnaireComponent } from './gestionnaires/sign-up-gestionnaire/sign-up-gestionnaire.component';
import { DecideurComponent } from './decideur/decideur.component';
import { AutorisationChartComponent } from './decideur/autorisation-chart/autorisation-chart.component';
import { ChartsModule } from 'ng2-charts';
import { AutorisationEquipementComponent } from './decideur/autorisation-chart/autorisation-equipement/autorisation-equipement.component';
// tslint:disable-next-line: max-line-length
import { AutorisationGestionnaireComponent } from './decideur/autorisation-chart/autorisation-gestionnaire/autorisation-gestionnaire.component';
import { DemandesChartComponent } from './decideur/demandes-chart/demandes-chart.component';
import { DemandesDemandeurComponent } from './decideur/demandes-chart/demandes-demandeur/demandes-demandeur.component';
import { DemandesViewComponent } from './decideur/demandes-chart/demandes-view/demandes-view.component';
import { AutorisationsViewComponent } from './decideur/autorisation-chart/autorisations-view/autorisations-view.component';
import { ProfilViewComponent } from './gestionnaires/profile/profil-view/profil-view.component';
import { ProfileViewComponent } from './demandeur/demandeur-profile/profile-view/profile-view.component';
import { AutorisationPieChartComponent } from './decideur/autorisation-chart/autorisation-pie-chart/autorisation-pie-chart.component';
import { SearchFilter } from './pipes/searchFilter.pipe';
import { SearchEquipementFilter } from './pipes/searchEquipementFilter.pipe';
import { SearchObjetFilter } from './pipes/searchObjetFilter.pipe';
import { MessageAlertComponent } from './message-alert/message-alert.component';
import { SearchAutoFilter } from './pipes/autorisations/searchAutoFilter.pipe';
import { SearchEquipementAutoFilter } from './pipes/autorisations/searchEquipementAutoFilter.pipe';
import { SearchObjetAutoFilter } from './pipes/autorisations/searchObjetAutoFilter.pipe';
import { SearchUsernameFilter } from './pipes/demandeurs/searchUsernameFilter.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ActualiteComponent,
    HomeComponent,
    LoginUserComponent,
    SignupUserComponent,
    ListEquipementsComponent,
    EquipementSumComponent,
    EquipementDetailComponent,
    DemandeComponent,
    DemandesComponent,
    ReservationsComponent,
    AutorisationsComponent,
    DemandeFormulaireComponent,
    DemandeUnitComponent,
    ReservationViewComponent,
    DemandeSummaryComponent,
    ReservationUnitComponent,
    AutorisationUnitComponent,
    FooterComponent,
    ProfileComponent,
    DemandeurProfileComponent,
    AuthenticationComponent,
    DemandeursComponent,
    DemandeurUnitComponent,
    ListDemandesComponent,
    DemandeViewComponent,
    ViewFileComponent,
    DemandeDetailComponent,
    EquipementUpdateComponent,
    EquipementCreateComponent,
    SignUpGestionnaireComponent,
    DecideurComponent,
    AutorisationChartComponent,
    AutorisationEquipementComponent,
    AutorisationGestionnaireComponent,
    ProfileViewComponent,
    DemandesChartComponent,
    DemandesDemandeurComponent,
    DemandesViewComponent,
    AutorisationsViewComponent,
    ProfilViewComponent,
    AutorisationPieChartComponent,
    SearchFilter,
    SearchEquipementFilter,
    SearchObjetFilter,
    MessageAlertComponent,
    SearchAutoFilter,
    SearchEquipementAutoFilter,
    SearchObjetAutoFilter,
    SearchUsernameFilter
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    DataViewModule,
    DropdownModule,
    PanelModule,
    DialogModule,
    PdfViewerModule,
    ClarityModule,
    BrowserAnimationsModule,
    GoogleMapsModule,
    // tslint:disable-next-line: deprecation
    HttpModule,
    ChartsModule,
  ],
  providers: [AuthService, EquipementsService, AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
