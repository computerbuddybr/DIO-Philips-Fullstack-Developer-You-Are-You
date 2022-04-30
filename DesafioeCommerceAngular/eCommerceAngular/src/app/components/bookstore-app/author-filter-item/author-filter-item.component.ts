import {Component, Input, OnInit} from '@angular/core';
import {Author} from "../author-list/model/Author";
import {BooksService} from "../product-list/product-list.component.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-author-filter-item',
  templateUrl: './author-filter-item.component.html',
  styleUrls: ['./author-filter-item.component.css']
})
export class AuthorFilterItemComponent implements OnInit {

  @Input()
  authorInfo!: Author;
  books: any;
  booksServices: BooksService;



  constructor(booksServices: BooksService) {
    this.booksServices = booksServices;
  }

  ngOnInit(): void {


  }

  onAuthor(id:number){
    this.books = this.booksServices.getBooksByAuthor(id).subscribe((data => {
      this.books = data;
      //console.log(this.books);
    }));
  }

}
