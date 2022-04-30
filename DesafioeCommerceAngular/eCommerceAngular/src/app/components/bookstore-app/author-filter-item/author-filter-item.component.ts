import {Component, Input, OnInit} from '@angular/core';
import {Author} from "../author-list/model/Author";
import {BooksService} from "../product-list/product-list.component.service";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-author-filter-item',
  templateUrl: './author-filter-item.component.html',
  styleUrls: ['./author-filter-item.component.css']
})
export class AuthorFilterItemComponent implements OnInit {

  @Input()
  authorInfo!: Author;




  constructor() {

  }

  ngOnInit(): void {


  }



}
