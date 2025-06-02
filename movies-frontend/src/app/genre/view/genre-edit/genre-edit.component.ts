import {Component, OnInit} from '@angular/core';
import {GenreForm} from '../../model/genre-form.model';
import {Genres} from '../../model/genres.model';
import {GenreService} from '../../service/genre.service';
import {ActivatedRoute, Router} from '@angular/router';
import {NgFor, NgIf} from '@angular/common';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-genre-edit',
  imports: [NgIf, NgFor, FormsModule],
  templateUrl: './genre-edit.component.html',
  styleUrl: './genre-edit.component.css'
})
export class GenreEditComponent implements OnInit {
  uuid: string | undefined;
  genre: GenreForm | undefined;
  original: GenreForm | undefined;

  constructor(
    private genreService: GenreService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.genreService.getGenre(params['uuid'])
        .subscribe(genre => {
          this.uuid = genre.id;
          this.genre = {
            name: genre.name
          }
          this.original = {...this.genre};
        })
    })
  }

  onSubmit(): void {
    this.genreService.updateGenre(this.uuid!, this.genre!)
      .subscribe(() => {
        this.router.navigate(['/genres']);
      });
  }

}
