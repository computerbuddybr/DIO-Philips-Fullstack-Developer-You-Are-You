import { Component, OnInit } from '@angular/core';
import {AuthorsServices} from "./author-list.component.service";

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.css']
})
export class AuthorListComponent implements OnInit {

  authors: any;
  authorsServices :  AuthorsServices;

  constructor(authorsService :  AuthorsServices) {
    this.authorsServices = authorsService;
  }

  ngOnInit(): void {
    this.authors = this.authorsServices.getAuthor().subscribe((data => {
      this.authors = data;
      //console.log(this.authors);
    }));
  }

}
