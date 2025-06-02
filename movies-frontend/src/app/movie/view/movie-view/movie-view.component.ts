import {Component, OnInit} from '@angular/core';
import {MovieService} from '../../service/movie.service';
import {ActivatedRoute, Router} from '@angular/router';
import {NgFor, NgIf} from '@angular/common';
import {MovieDetails} from '../../model/movie-details.model';

@Component({
  selector: 'app-movie-view',
  imports: [NgIf, NgFor],
  templateUrl: './movie-view.component.html',
  styleUrl: './movie-view.component.css'
})
export class MovieViewComponent implements OnInit {
  constructor(private service: MovieService, private route: ActivatedRoute, private router: Router) {}

  movie: MovieDetails | undefined

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getMovie(params['uuid'])
        .subscribe(movie => this.movie = movie)
    })
  }

}
