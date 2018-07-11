import {Routes} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {PersonalComponent} from "./personal/personal.component";
import {SkillComponent} from "./skill/skill.component";
import {DemandComponent} from "./demand/demand.component";

export const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'ang/home',
    pathMatch: 'full'
  },
  {
    path: 'ang/home',
    component: HomeComponent
  },
  {
    path: 'ang/personal',
    component: PersonalComponent
  },
  {
    path: 'ang/skill',
    component: SkillComponent
  },
  {
    path: 'ang/demand',
    component: DemandComponent
  }
];
