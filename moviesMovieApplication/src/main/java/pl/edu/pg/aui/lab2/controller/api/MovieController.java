package pl.edu.pg.aui.lab2.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.edu.pg.aui.lab2.dtos.GetMovieResponse;
import pl.edu.pg.aui.lab2.dtos.GetMoviesResponse;
import pl.edu.pg.aui.lab2.dtos.PatchMovieRequest;
import pl.edu.pg.aui.lab2.dtos.PutMovieRequest;
import pl.edu.pg.aui.lab2.function.UpdateMovieWithRequestFunction;

import java.util.UUID;

public interface MovieController {
    @GetMapping("api/movies")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMoviesResponse getMovies();

    @GetMapping("/api/genres/{genreId}/movies")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMoviesResponse getGenreMovies(
            @PathVariable("genreId")
            UUID genreId);

    @GetMapping("/api/movies/{movieId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    GetMovieResponse getMovie(
            @PathVariable("movieId")
            UUID movieId);

    @PutMapping("/api/movies/{movieId}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    void putMovie(
            @PathVariable("movieId")
            UUID movieId,
            @RequestBody
            PutMovieRequest request);

//    @PutMapping("/api/genres/{genreId}/movies")
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    void putMovieInsideGenre(
//            @PathVariable("genreId")
//            UUID genreId,
//            @RequestBody
//            PutMovieRequest request);

    @DeleteMapping("/api/movies/{movieId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMovie(
            @PathVariable("movieId")
            UUID movieId);

    @DeleteMapping("/api/movies/genre/{genreId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMoviesByGenre(@PathVariable("genreId") UUID genreId);

    @PatchMapping("/api/movies/{movieId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    void patchMovie(
            @PathVariable("movieId")
            UUID movieId,
            @RequestBody
            PatchMovieRequest request);
}
