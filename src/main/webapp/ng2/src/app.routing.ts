import { ModuleWithProviders }  from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

//import {provideRouter, RouterConfig } from '@angular/router';

import { ItemListComponent } from 'src/components/itemList.component';

const appRoutes: Routes = [
  { path: 'items', component: ItemListComponent },
  { path: '**', redirectTo: 'items' } //Default & Fallback Route
];

export const appRoutingProviders: any[] = [

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes, {useHash: true});
