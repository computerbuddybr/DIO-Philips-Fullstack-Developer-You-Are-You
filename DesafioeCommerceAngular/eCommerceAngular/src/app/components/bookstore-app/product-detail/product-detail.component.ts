import { Component, OnInit } from '@angular/core';
import {BooksService} from "../product-list/product-list.component.service";
import {ActivatedRoute} from "@angular/router";
import {Book} from "../product-list/model/Book";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {

  books: any;
  booksServices: BooksService;


  constructor(booksServices: BooksService, private route: ActivatedRoute) {
    this.booksServices = booksServices;

  }

  ngOnInit(): void {

   let id = this.route.snapshot.params['bookID'];

   if(!(id >= 1)){
     id = 1;
   }

    this.books = this.booksServices.getBookByID(id).subscribe((data => {
      this.books = data;
      console.log(this.books);
    }));


  }


}
