import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  name : string;
  age : number;
  email : string;
  imagepath : string;
  width : number;
  height : number;
  myStyle : {};
  myClass : string;
  fname : string = "";
  
  //defining constructor using "constructor" keyword
  constructor(){
    this.name = "Neha";
    this.age = 19;
    this.email = "neha@gmail.com";
    this.imagepath = "./smiley.png"
    this.width = 200;
    this.height = 200;
    this.myStyle = { "color" : "green", "font-size" : "15px" };
    this.myClass = "ZoomIn";
  }

  //defining function
  getAddition(a : number, b : number) : number {
    return a + b;
  }

  //event binding methods

  changeName(){
    if(this.name === "Neha")
      this.name = "P Neha";
    else
      this.name = "Neha";
  }

  zoomInOut(){
    if(this.myClass === "ZoomIn")
      this.myClass = "ZoomOut";
    else
      this.myClass = "ZoomIn";
  }
}
