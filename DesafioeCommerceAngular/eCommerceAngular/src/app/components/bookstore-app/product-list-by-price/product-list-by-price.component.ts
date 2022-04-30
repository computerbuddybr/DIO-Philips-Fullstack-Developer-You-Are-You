import { Component, OnInit } from '@angular/core';
import {BooksService} from "../product-list/product-list.component.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-product-list-by-price',
  templateUrl: './product-list-by-price.component.html',
  styleUrls: ['./product-list-by-price.component.css']
})
export class ProductListByPriceComponent implements OnInit {

  books: any;
  booksServices: BooksService;

  constructor(booksServices: BooksService, private route: ActivatedRoute) {
    this.booksServices = booksServices;
  }

  ngOnInit(): void {
    let minPrice = this.route.snapshot.params['minPrice'];
    console.log(minPrice);
    let maxPrice = this.route.snapshot.params['maxPrice'];
    if(!(minPrice > 0)){
      minPrice = 0;

    }
    if(!(maxPrice > 0)){
      maxPrice = 2000;
    }


    this.books = this.booksServices.getBooksByPrice(minPrice, maxPrice).subscribe((data => {
      this.books = data;
      console.log(this.books);
    }));
  }

}
