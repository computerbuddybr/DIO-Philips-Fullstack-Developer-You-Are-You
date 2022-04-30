import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductListByAuthorComponent } from './product-list-by-author.component';

describe('ProductListByAuthorComponent', () => {
  let component: ProductListByAuthorComponent;
  let fixture: ComponentFixture<ProductListByAuthorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductListByAuthorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductListByAuthorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
