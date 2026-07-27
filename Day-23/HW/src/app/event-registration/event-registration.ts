import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-event-registration',
  imports: [CommonModule],
  templateUrl: './event-registration.html',
  styleUrl: './event-registration.css',
})
export class EventRegistration {
  registrationMessage: string = '';

  register(name: string, email: string, course: string): void {
    console.log('--- Registration Details ---');
    console.log('Name:', name);
    console.log('Email:', email);
    console.log('Course:', course);

    this.registrationMessage = 'Registration Successful';
  }

  reset(name: HTMLInputElement, email: HTMLInputElement, course: HTMLInputElement): void {
    name.value = '';
    email.value = '';
    course.value = '';
    this.registrationMessage = '';
  }
}
