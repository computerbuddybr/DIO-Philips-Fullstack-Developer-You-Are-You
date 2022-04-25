import { Injectable} from "@angular/core";

import {HttpClient, HttpHeaders} from "@angular/common/http";

import { Author} from "./model/Author";

@Injectable()

export class AuthorsServices{
  private url = "http://localhost:8080/authors";


  httpOptions = {
    Headers: new HttpHeaders({
      'content-type' :  'application/json'})
  }

  constructor(private http:HttpClient) {
  }

  getAuthor(){
    return this.http.get(this.url);
  }

}


