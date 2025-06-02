import {Genre} from '../../genre/model/genre.model';

export interface MovieForm {
  // id: string;
  title: string;
  director: string;
  releaseYear: number;
  genreId: string;
}
