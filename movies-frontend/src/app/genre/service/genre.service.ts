import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Genres} from '../model/genres.model';
import {Genre} from '../model/genre.model';
import {GenreForm} from '../model/genre-form.model';

@Injectable({
  providedIn: 'root'
})
export class GenreService {

  constructor(private http:HttpClient) { }

  getGenres(): Observable<Genres> {
    return this.http.get<Genres>('/api/genres');
  }

  getGenre(uuid: string): Observable<Genre> {
    return this.http.get<Genre>(`/api/genres/${uuid}`);
  }

  deleteGenre(uuid: string): Observable<any> {
    return this.http.delete(`/api/genres/${uuid}`);
  }

  putGenre(uuid: string, request: GenreForm): Observable<any> {
    return this.http.put(`/api/genres/${uuid}`, request);
  }

  updateGenre(uuid: string, request: GenreForm): Observable<any> {
    return this.http.patch(`/api/genres/${uuid}`, request);
  }

}
