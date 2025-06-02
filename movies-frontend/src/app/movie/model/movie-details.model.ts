import {Genre} from '../../genre/model/genre.model';

export interface MovieDetails {
  id: string;
  title: string;
  director: string;
  releaseYear: number;
  genre: Genre;
}
