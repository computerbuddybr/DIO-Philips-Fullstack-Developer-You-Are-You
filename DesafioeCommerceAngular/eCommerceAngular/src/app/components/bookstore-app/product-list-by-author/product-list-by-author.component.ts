import { Component, OnInit } from '@angular/core';
import {BooksService} from "../product-list/product-list.component.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-product-list-by-author',
  templateUrl: './product-list-by-author.component.html',
  styleUrls: ['./product-list-by-author.component.css']
})
export class ProductListByAuthorComponent implements OnInit {

  books: any;
  booksServices: BooksService;


  constructor(booksServices: BooksService, private route: ActivatedRoute) {
    this.booksServices = booksServices;
  }

  ngOnInit(): void {

      let id = this.route.snapshot.params['authorID'];

    this.books = this.booksServices.getBooksByAuthor(id).subscribe((data => {
      this.books = data;
      console.log(this.books);
    }));
  }

}
