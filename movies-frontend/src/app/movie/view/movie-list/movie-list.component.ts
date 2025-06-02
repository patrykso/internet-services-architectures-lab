import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../service/movie.service';
import { Movies } from '../../model/movies.model';
import { Movie } from '../../model/movie.model';
import { NgFor, NgIf } from '@angular/common';
import {ActivatedRoute, RouterLink} from '@angular/router';

@Component({
  selector: 'app-movie-list',
  imports: [NgIf, NgFor, RouterLink],
  templateUrl: './movie-list.component.html',
  styleUrl: './movie-list.component.css',
})
export class MovieListComponent implements OnInit {
  constructor(private service: MovieService, private route: ActivatedRoute) {}

  movies: Movies | undefined;

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      const genreUuid = params['uuid'];
      if (genreUuid) {
        this.service
          .getMoviesByGenre(genreUuid)
          .subscribe((movies) => (this.movies = movies));
      } else {
        this.service.getMovies().subscribe((movies) => (this.movies = movies));
      }
    });
  }

  onDelete(movie: Movie): void {
    this.service.deleteMovie(movie.id).subscribe(() => this.ngOnInit());
  }
}
