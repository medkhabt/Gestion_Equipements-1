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
    EquipementDetailComponent
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
    DialogModule
  ],
  providers: [AuthService, EquipementsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
