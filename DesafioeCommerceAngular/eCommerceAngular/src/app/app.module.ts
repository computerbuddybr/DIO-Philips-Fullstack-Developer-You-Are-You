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
import {RouterModule, Routes} from "@angular/router";
import { ProductDetailComponent } from './components/bookstore-app/product-detail/product-detail.component';
import { ProductListByAuthorComponent } from './components/bookstore-app/product-list-by-author/product-list-by-author.component';
import { ProductListByPriceComponent } from './components/bookstore-app/product-list-by-price/product-list-by-price.component';

const appRoutes: Routes = [
  { path: '', component: BookstoreAppComponent},
  { path: 'books', component: ProductListComponent},
  { path: 'books/:bookID', component: ProductDetailComponent},
  { path: 'books/:minPrice/:maxPrice', component: ProductListByPriceComponent},
  { path: 'authors', component: AuthorListComponent },
  { path: 'authors/:authorID', component: ProductListByAuthorComponent }
];

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
    AuthorFilterItemComponent,
    ProductDetailComponent,
    ProductListByAuthorComponent,
    ProductListByPriceComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    BooksService,
    AuthorsServices
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
