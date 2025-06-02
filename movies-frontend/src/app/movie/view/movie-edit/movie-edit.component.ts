import {Component, NgModule, OnInit} from '@angular/core';
import {MovieForm} from '../../model/movie-form.model';
import {Genres} from '../../../genre/model/genres.model';
import {MovieService} from '../../service/movie.service';
import {GenreService} from '../../../genre/service/genre.service';
import {ActivatedRoute, Router} from '@angular/router';
import {NgFor, NgIf} from '@angular/common';
import {FormsModule, NgForm} from '@angular/forms';

@Component({
  selector: 'app-movie-edit',
  imports: [NgIf, NgFor, FormsModule],
  templateUrl: './movie-edit.component.html',
  styleUrl: './movie-edit.component.css'
})
export class MovieEditComponent implements OnInit {
  uuid: string | undefined;
  movie: MovieForm | undefined;
  original: MovieForm | undefined;
  genres: Genres | undefined;

  constructor(
    private movieService: MovieService,
    private genreService: GenreService,
    private router: Router,
    private route: ActivatedRoute
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.genreService.getGenres()
        .subscribe(genres => this.genres = genres);

      this.movieService.getMovie(params['uuid'])
        .subscribe(movie => {
          this.uuid = movie.id;
          this.movie = {
            title: movie.title,
            director: movie.director,
            releaseYear: movie.releaseYear,
            genreId: movie.genre.id
          }
          this.original = {...this.movie};
        })
    })
  }

  onSubmit(): void {
    if (this.movie) {
      const movieToSubmit: MovieForm = {
        title: this.movie.title || '',
        director: this.movie.director || '',
        releaseYear: this.movie.releaseYear || 0,
        genreId: this.movie.genreId || ''
      };

      console.log('movieToSubmit:', movieToSubmit);

      this.movieService.putMovie(this.uuid!, movieToSubmit)
        .subscribe(() => this.router.navigate(['/movies']));
    }
  }

}
