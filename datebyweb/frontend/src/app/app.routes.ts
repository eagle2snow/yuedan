import {Routes} from "@angular/router";
import {HomeComponent} from "./home/home.component";

export const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'ang/home',
    pathMatch: 'full'
  },
  {
    path: 'ang/home',
    component: HomeComponent
  }
];
