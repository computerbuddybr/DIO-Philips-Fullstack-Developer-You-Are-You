import {Component, Input, OnInit} from '@angular/core';
import {AuthorsServices} from "../author-list/author-list.component.service";

@Component({
  selector: 'app-filters',
  templateUrl: './filters.component.html',
  styleUrls: ['./filters.component.css']
})
export class FiltersComponent implements OnInit {
  authorsInfo: any;
  authorsServices :  AuthorsServices;
  minPrice: any;
  maxPrice: any;
  paraTestar: string = "";


  constructor(authorsService :  AuthorsServices) {
    this.authorsServices = authorsService;
  }

  ngOnInit(): void {
    this.authorsInfo = this.authorsServices.getAuthor().subscribe((data => {
      this.authorsInfo = data;

    }));
  }

  onFilterByAuthorFormSend(event: any){
      this.paraTestar = "Cliquei no botão do autor";
  }
  onFilterByMinAndMaxPriceFormSend(event: any){
    this.paraTestar = "Cliquei no botão do preço";
  }

}
