import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {NgFor, NgIf} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {MovieService} from '../../../movie/service/movie.service';
import {GenreService} from '../../service/genre.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-genre-add-form',
  imports: [NgIf, NgFor, FormsModule],
  templateUrl: './genre-add-form.component.html',
  styleUrl: './genre-add-form.component.css'
})
export class GenreAddFormComponent {
  constructor(
    private movieService: MovieService,
    private genreService: GenreService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  @Output() genreAdded = new EventEmitter<void>();
  genreUUID: string = "11111111-1111-1111-1111-111111111111";
  genreName: string = '';

  onSubmit(): void {
    if (this.genreName) {
      const genreToSubmit = {
        name: this.genreName
      };

      console.log('genreToSubmit:', genreToSubmit);

      this.genreService.putGenre(this.genreUUID, genreToSubmit).subscribe(() => {
        this.genreAdded.emit();
      });
    }
  }
}
