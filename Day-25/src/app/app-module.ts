import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { EmployeeComponent } from './components/employee-component/employee-component';
import { EmployeeService } from './services/employee-service';
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [App, EmployeeComponent],
  imports: [BrowserModule, AppRoutingModule,FormsModule,HttpClientModule],
  providers: [provideBrowserGlobalErrorListeners(),EmployeeService],
  bootstrap: [App],
})
export class AppModule {}
