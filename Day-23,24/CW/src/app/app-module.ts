import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Child1 } from './child1/child1';
import { Child2 } from './child2/child2';
import { StructuralDirectives } from './structural-directives/structural-directives';
import { CalculatorService } from './calculator-service';
import { AdditionComponent } from './addition-component/addition-component';
import { EmployeeComponent } from './employee-component/employee-component';
import { DateComponent } from './date-component/date-component';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    // registers all components here. loads everything in one shot. (same as IOC...kind of)
    App,
    Child1,
    Child2,
    StructuralDirectives,
    AdditionComponent,
    EmployeeComponent,
    DateComponent,
  ],
  imports: [
  BrowserModule,
  CommonModule,
  FormsModule,
  AppRoutingModule
],
  providers: [provideBrowserGlobalErrorListeners(), CalculatorService],
  bootstrap: [App], // to specify the root component.
})
export class AppModule {}
