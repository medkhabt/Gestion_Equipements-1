import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { ListEquipementsComponent } from './list-equipements/list-equipements.component';
import { EquipementDetailComponent } from './list-equipements/equipement-detail/equipement-detail.component';
import { EquipementSumComponent } from './list-equipements/equipement-sum/equipement-sum.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    ListEquipementsComponent,
    EquipementDetailComponent,
    EquipementSumComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
