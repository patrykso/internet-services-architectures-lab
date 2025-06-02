import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieAddFormComponent } from './movie-add-form.component';

describe('MovieAddFormComponent', () => {
  let component: MovieAddFormComponent;
  let fixture: ComponentFixture<MovieAddFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MovieAddFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MovieAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
