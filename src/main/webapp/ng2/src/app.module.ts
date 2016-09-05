import { NgModule }      from '@angular/core';
//import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

import { HttpModule } from '@angular/http';

import { routing, appRoutingProviders } from 'src/app.routing';

import { MDL } from 'src/directives/mdl.directive';

import { AppComponent } from 'src/app.component';
import { ItemListComponent } from 'src/components/itemList.component';

// Add the RxJS Observable operators we need in this app.
import 'src/util/rxjs-operators';

@NgModule({
  imports:  [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule,
    routing
  ],
  declarations: [
    MDL,
    AppComponent,
    ItemListComponent
  ],
  providers : [
    //{ provide: LocationStrategy, useClass: HashLocationStrategy },
    appRoutingProviders
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
