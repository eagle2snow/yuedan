import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import {appRoutes} from "./app.routes";
import { HomeComponent } from './home/home.component';
import { SkillComponent } from './skill/skill.component';
import { PersonalComponent } from './personal/personal.component';
import { NeedsComponent } from './needs/needs.component';
import { ToolComponent } from './tool/tool.component';
// import { ToolComponent } from './tool/tool.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SkillComponent,
    PersonalComponent,
    NeedsComponent,
    ToolComponent,
    // ToolComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
