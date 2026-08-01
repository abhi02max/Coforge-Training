import { Component } from '@angular/core';

@Component({
  selector: 'app-product',
  imports: [],
  templateUrl: './product.html',
  styleUrl: './product.css',
})
export class Product {
  productName: string = 'Wireless Noise-Canceling Headphones';
  price: number = 14999;
  category: string = 'Electronics';
  brand: string = 'AudioTech';
  image: string = 'headphones.jpeg';
  isAvailable: boolean = true;
}
