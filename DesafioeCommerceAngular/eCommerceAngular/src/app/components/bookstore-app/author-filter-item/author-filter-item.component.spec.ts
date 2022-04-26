import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorFilterItemComponent } from './author-filter-item.component';

describe('AuthorFilterItemComponent', () => {
  let component: AuthorFilterItemComponent;
  let fixture: ComponentFixture<AuthorFilterItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AuthorFilterItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorFilterItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
