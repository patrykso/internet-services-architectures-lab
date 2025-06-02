package pl.edu.pg.aui.lab2.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pl.edu.pg.aui.lab2.controller.api.GenreController;
import pl.edu.pg.aui.lab2.services.GenreService;

import java.util.UUID;

@RestController
@Log
public class GenreDefaultController implements GenreController {
    private final GenreService genreService;
//    private final GenreToResponseFunction genreToResponse;
//    private final GenresToResponseFunction genresToResponse;
//    private final RequestToGenreFunction requestToGenre;

    @Autowired
    public GenreDefaultController(
            GenreService genreService)
//            GenreToResponseFunction genreToResponse,
//            GenresToResponseFunction genresToResponse,
//            RequestToGenreFunction requestToGenre) {
    {
        this.genreService = genreService;
//        this.genreToResponse = genreToResponse;
//        this.requestToGenre = requestToGenre;
//        this.genresToResponse = genresToResponse;
    }

//    @Override
//    public GetGenresResponse getGenres() {
//        return genresToResponse.apply(genreService.findAll());
//    }
//
//    @Override
//    public GetGenreResponse getGenre(UUID id) {
//        return genreService.find(id)
//                .map(genreToResponse)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }

    @Override
    public void deleteGenre(UUID id) {
        genreService.find(id)
                .ifPresentOrElse(
                        genre -> genreService.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

//    @Override
//    public void putGenre(UUID id, PutGenreRequest request) {
//        genreService.save(requestToGenre.apply(id, request));
//    }
//
//    @Override
//    public void patchGenre(UUID id, PutGenreRequest request) {
//        genreService.find(id)
//                .ifPresentOrElse(
//                        genre -> genreService.save(requestToGenre.apply(id, request)),
//                        () -> {
//                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//                        }
//                );
//    }
}
