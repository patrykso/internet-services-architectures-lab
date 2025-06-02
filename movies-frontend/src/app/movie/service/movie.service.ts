import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Movies} from '../model/movies.model';
import {MovieForm} from '../model/movie-form.model';
import {MovieDetails} from '../model/movie-details.model';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  constructor(private http: HttpClient) { }

  getMovies(): Observable<Movies> {
    return this.http.get<Movies>('/api/movies');
  }

  getMovie(uuid: string): Observable<MovieDetails> {
    return this.http.get<MovieDetails>(`/api/movies/${uuid}`);
  }

  getMoviesByGenre(uuid: string): Observable<Movies> {
    return this.http.get<Movies>(`/api/genres/${uuid}/movies`);
  }

  deleteMovie(uuid: string): Observable<any> {
    return this.http.delete(`/api/movies/${uuid}`);
  }

  putMovie(uuid: string, request: MovieForm): Observable<any> {
    return this.http.put(`/api/movies/${uuid}`, request);
  }
}
