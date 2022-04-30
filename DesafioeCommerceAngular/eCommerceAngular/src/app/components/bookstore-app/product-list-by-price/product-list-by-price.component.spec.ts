import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductListByPriceComponent } from './product-list-by-price.component';

describe('ProductListByPriceComponent', () => {
  let component: ProductListByPriceComponent;
  let fixture: ComponentFixture<ProductListByPriceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductListByPriceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductListByPriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
