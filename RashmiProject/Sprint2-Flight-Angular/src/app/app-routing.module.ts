import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddFlightComponent } from './add-flight/add-flight.component';
//import { FlightDetailsComponent } from './flight-details/flight-details.component';
//import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { ListFlightsComponent } from './list-flights/list-flights.component';
import { UpdateFlightComponent } from './update-flight/update-flight.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';


const routes: Routes = [
  {
path:'add-flight',
component: AddFlightComponent
},
{
  path:'update-flight',
  component:UpdateFlightComponent
},
{
path:'list-flights',
component:ListFlightsComponent
},
{
  path:'search-flight',
  component:SearchFlightComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
