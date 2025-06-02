import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenreAddFormComponent } from './genre-add-form.component';

describe('GenreAddFormComponent', () => {
  let component: GenreAddFormComponent;
  let fixture: ComponentFixture<GenreAddFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GenreAddFormComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GenreAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
