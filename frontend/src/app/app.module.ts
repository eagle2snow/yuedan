import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {RouterModule} from '@angular/router';
import {appRoutes} from "./app.routes";
import {SkillComponent} from './skill/skill.component';
import {PersonalComponent} from './personal/personal.component';
import {ToolComponent} from './tool/tool.component';
import {AppComponent} from "./app.component";
import {HomeComponent} from "./home/home.component";
import {DemandComponent} from './demand/demand.component';
import {SpaComponent} from './home/spa/spa.component';
import {NavibarComponent} from './navibar/navibar.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SkillComponent,
    PersonalComponent,
    ToolComponent,
    DemandComponent,
    SpaComponent,
    NavibarComponent,

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
