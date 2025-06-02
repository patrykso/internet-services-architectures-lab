import { Routes } from '@angular/router';
import {GenreListComponent} from './genre/view/genre-list/genre-list.component';
import {MovieListComponent} from './movie/view/movie-list/movie-list.component';
import {GenreViewComponent} from './genre/view/genre-view/genre-view.component';
import {GenreEditComponent} from './genre/view/genre-edit/genre-edit.component';
import {MovieViewComponent} from './movie/view/movie-view/movie-view.component';
import {MovieEditComponent} from './movie/view/movie-edit/movie-edit.component';

export const routes: Routes = [
  {
    path: 'genres', component: GenreListComponent },
  {
    path: 'movies', component: MovieListComponent
  },
  {
    path: 'genres/:uuid', component: GenreViewComponent
  },
  {
    path: 'genres/:uuid/edit', component: GenreEditComponent
  },
  {
    path: 'movies/:uuid', component: MovieViewComponent
  },
  {
    path: 'movies/:uuid/edit', component: MovieEditComponent
  }
];
