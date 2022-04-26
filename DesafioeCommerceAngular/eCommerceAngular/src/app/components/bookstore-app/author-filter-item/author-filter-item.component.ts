import {Component, Input, OnInit} from '@angular/core';
import {Author} from "../author-list/model/Author";

@Component({
  selector: 'app-author-filter-item',
  templateUrl: './author-filter-item.component.html',
  styleUrls: ['./author-filter-item.component.css']
})
export class AuthorFilterItemComponent implements OnInit {

  @Input()
  authorInfo!: Author;
  constructor() { }

  ngOnInit(): void {
    console.log("Inside filter component:");

  }

}
