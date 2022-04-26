import {Component, Input, OnInit} from '@angular/core';
import {Author} from "../author-list/model/Author";

@Component({
  selector: 'app-author-item',
  templateUrl: './author-item.component.html',
  styleUrls: ['./author-item.component.css']
})
export class AuthorItemComponent implements OnInit {

  @Input()
  author!: Author;
  constructor() { }

  ngOnInit(): void {
  }

  onAuthorsBooks(event: any){

  }

}
