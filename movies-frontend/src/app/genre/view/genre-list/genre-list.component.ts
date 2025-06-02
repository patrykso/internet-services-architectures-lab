import {Component, OnInit} from '@angular/core';
import { GenreService } from '../../service/genre.service';
import { Genre } from '../../model/genre.model';
import { NgIf, NgFor } from '@angular/common';
import {RouterLink} from '@angular/router';
import {GenreAddFormComponent} from '../genre-add-form/genre-add-form.component';

@Component({
  selector: 'app-genre-list',
  imports: [NgIf, NgFor, RouterLink, GenreAddFormComponent],
  templateUrl: './genre-list.component.html',
  styleUrl: './genre-list.component.css'
})
export class GenreListComponent implements OnInit {
  constructor(private service: GenreService) {}

  genres: Genre[] | undefined;

  ngOnInit() {
    this.service.getGenres().subscribe(genres => this.genres = genres.genres);
  }

  onDelete(genre: Genre): void {
    this.service.deleteGenre(genre.id).subscribe(() => this.ngOnInit());
  }

  refreshGenres(): void {
    this.service.getGenres().subscribe(genres => this.genres = genres.genres);
  }
}
