import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddFlightComponent } from './add-flight/add-flight.component';

import { HttpClientModule } from '@angular/common/http';
import { FlightService } from './services/flightservice';
import { ListFlightsComponent } from './list-flights/list-flights.component';
import { AscendingOrder } from './pipes/ascodered';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';



@NgModule({
  declarations: [
    AppComponent,
    AddFlightComponent,
    UpdateFlightComponent,
    ListFlightsComponent,
    AscendingOrder,
    SearchFlightComponent
   
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [FlightService],
  bootstrap: [AppComponent]
})
export class AppModule { }
