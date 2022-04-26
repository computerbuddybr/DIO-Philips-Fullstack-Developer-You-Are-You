import {Component, Input, OnInit} from '@angular/core';
import {Book} from "../product-list/model/Book";

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {

  @Input()
  book! : Book;
  constructor() { }

  ngOnInit(): void {
  }

  onBuy(event: any){
    console.log(event);
    //TODO: adicionar ao carrinho
  }
  onDetails(event: any){
    console.log(event);
    //TODO:ir para página e passar o id para a página
  }

}
