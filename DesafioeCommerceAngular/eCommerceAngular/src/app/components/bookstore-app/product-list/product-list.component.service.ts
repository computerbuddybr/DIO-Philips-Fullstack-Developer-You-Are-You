import { Injectable} from "@angular/core";

import {HttpClient, HttpHeaders} from "@angular/common/http";

import { Book} from "./model/Book";

@Injectable()

export class BooksService{
  private url = "http://localhost:8080/";
  private urlBooksByAuthor = "http://localhost:8080/authors/";

  private urlBooksByPrice = "http://localhost:8080/books/";
  httpOptions = {
    Headers: new HttpHeaders({
  'content-type' :  'application/json'})
  }

  constructor(private http:HttpClient) {
  }

  getBook(){
    return this.http.get(this.url);
  }

  /**
   * Asking the API for the list of books by max and min prices
   * @param minPrice
   * @param maxPrice
   */
  getBooksByPrice(minPrice: number, maxPrice:number){
    let urlToUse: string = this.urlBooksByPrice + "/" + minPrice + "/" + maxPrice;
    return this.http.get(urlToUse);
  }

  /**
   * Asking the API for the list of books by max and min prices
   * @param minPrice
   * @param maxPrice
   */
  getBooksByAuthor(authorID: number){
    let urlToUse: string = this.urlBooksByAuthor + "/" + authorID
    return this.http.get(urlToUse);
  }

}
