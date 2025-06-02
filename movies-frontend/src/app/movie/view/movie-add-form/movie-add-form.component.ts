import { Component, OnInit } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MovieForm } from '../../model/movie-form.model';
import { Genres } from '../../../genre/model/genres.model';
import { MovieService } from '../../service/movie.service';
import { GenreService } from '../../../genre/service/genre.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-movie-add-form',
  imports: [NgIf, NgFor, FormsModule],
  templateUrl: './movie-add-form.component.html',
  styleUrl: './movie-add-form.component.css'
})
export class MovieAddFormComponent implements OnInit {
  genreUuid: string = '';
  movie: MovieForm = { title: '', director: '', releaseYear: 0, genreId: '' };
  genres: Genres | undefined;
  movieUUID: string = "11111111-1111-1111-1111-111111111111"

  constructor(
    private movieService: MovieService,
    private genreService: GenreService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.genreUuid = params['uuid'];
      this.genreService.getGenres().subscribe(genres => (this.genres = genres));
    });
  }

  onSubmit(): void {
    if (this.movie && this.genreUuid) {
      const movieToSubmit: MovieForm = {
        title: this.movie.title || '',
        director: this.movie.director || '',
        releaseYear: this.movie.releaseYear || 0,
        genreId: this.genreUuid
      };

      console.log('movieToSubmit:', movieToSubmit);

      this.movieService.putMovie(this.movieUUID, movieToSubmit)
        .subscribe(() => this.router.navigate(['/movies']));
    }
  }
}
