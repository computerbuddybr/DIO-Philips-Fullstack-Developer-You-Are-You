import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HeaderComponent} from './components/shared/header/header.component';
import {FooterComponent} from './components/shared/footer/footer.component';
import {NavComponent} from './components/shared/nav/nav.component';

import {BookstoreAppComponent} from './components/bookstore-app/bookstore-app.component';
import {FiltersComponent} from './components/bookstore-app/filters/filters.component';
import {ProductListComponent} from "./components/bookstore-app/product-list/product-list.component";
import {ProductItemComponent} from './components/bookstore-app/product-item/product-item.component';
import {AuthorListComponent} from './components/bookstore-app/author-list/author-list.component';
import {AuthorItemComponent} from './components/bookstore-app/author-item/author-item.component';
import {HttpClientModule} from "@angular/common/http";
import {BooksService} from "./components/bookstore-app/product-list/product-list.component.service";
import {AuthorsServices} from "./components/bookstore-app/author-list/author-list.component.service";
import { AuthorFilterItemComponent } from './components/bookstore-app/author-filter-item/author-filter-item.component';
import {FormsModule} from "@angular/forms";



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    BookstoreAppComponent,
    FiltersComponent,
    ProductListComponent,
    ProductItemComponent,
    AuthorListComponent,
    AuthorItemComponent,
    AuthorFilterItemComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    BooksService,
    AuthorsServices
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
