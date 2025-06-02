package pl.edu.pg.aui.lab2.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.aui.lab2.controller.api.MovieController;
import pl.edu.pg.aui.lab2.dtos.GetMovieResponse;
import pl.edu.pg.aui.lab2.dtos.GetMoviesResponse;
import pl.edu.pg.aui.lab2.dtos.PatchMovieRequest;
import pl.edu.pg.aui.lab2.dtos.PutMovieRequest;
import pl.edu.pg.aui.lab2.function.MovieToResponseFunction;
import pl.edu.pg.aui.lab2.function.MoviesToResponseFunction;
import pl.edu.pg.aui.lab2.function.RequestToMovieFunction;
import pl.edu.pg.aui.lab2.function.UpdateMovieWithRequestFunction;
import pl.edu.pg.aui.lab2.services.MovieService;

import java.util.UUID;

@RestController
@Log
public class MovieDefaultController implements MovieController {
    private final MovieService movieService;
    private final MovieToResponseFunction movieToResponse;
    private final MoviesToResponseFunction moviesToResponse;
    private final RequestToMovieFunction requestToMovie;
    private final UpdateMovieWithRequestFunction patchMovie;

    @Autowired
    public MovieDefaultController(
            MovieService movieService,
            MovieToResponseFunction movieToResponse,
            MoviesToResponseFunction moviesToResponse,
            UpdateMovieWithRequestFunction UpdateMovieWithRequest,
            RequestToMovieFunction requestToMovie) {
        this.movieService = movieService;
        this.movieToResponse = movieToResponse;
        this.moviesToResponse = moviesToResponse;
        this.patchMovie = UpdateMovieWithRequest;
        this.requestToMovie = requestToMovie;
    }

    @Override
    public GetMoviesResponse getMovies() {
        return moviesToResponse.apply(movieService.findAll());
    }

    @Override
    public GetMoviesResponse getGenreMovies(UUID genreId) {
        return movieService.findAllByGenre(genreId)
                .map(moviesToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public GetMovieResponse getMovie(UUID id) {
        return movieService.find(id)
                .map(movieToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void putMovie(UUID id, PutMovieRequest request) {
        movieService.create(requestToMovie.apply(id, request));
    }

    @Override
    public void deleteMovie(UUID id) {
        movieService.find(id)
                .ifPresentOrElse(
                        movie -> movieService.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        });
    }

    @Override
    public void deleteMoviesByGenre(@PathVariable("genreId") UUID genreId) {
        movieService.findAllByGenre(genreId).ifPresent(movies -> {
            movies.forEach(movie -> movieService.delete(movie.getId()));
        });
    }

    @Override
    public void patchMovie(UUID movieId, PatchMovieRequest request) {
        movieService.find(movieId)
                .ifPresentOrElse(
                        movie -> movieService.create(patchMovie.apply(movie, request)),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        });
    }

    // @Override
    // public void putMovieInsideGenre(UUID genreId, PutMovieRequest request) {
    // movieService.save(requestToMovie.apply(genreId, request));
    // }
}
