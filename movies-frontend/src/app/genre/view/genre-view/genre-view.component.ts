import {Component, OnInit} from '@angular/core';
import {NgFor, NgIf} from '@angular/common';
import {GenreService} from '../../service/genre.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Genre} from '../../model/genre.model';
import {MovieListComponent} from '../../../movie/view/movie-list/movie-list.component';
import {MovieAddFormComponent} from '../../../movie/view/movie-add-form/movie-add-form.component';

@Component({
  selector: 'app-genre-view',
  imports: [NgIf, NgFor, MovieListComponent, MovieAddFormComponent],
  templateUrl: './genre-view.component.html',
  styleUrl: './genre-view.component.css'
})
export class GenreViewComponent implements OnInit {
  constructor(private service: GenreService, private route: ActivatedRoute, private router: Router) {}

  genre: Genre | undefined

  ngOnInit() {
      this.route.params.subscribe(params => {
        this.service.getGenre(params['uuid'])
          .subscribe(genre => this.genre = genre)
      });
  }

}
