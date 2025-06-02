package pl.edu.pg.aui.lab2.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface GenreController {
//    @GetMapping("/api/genres")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    GetGenresResponse getGenres();
//
//    @GetMapping("/api/genres/{id}")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    GetGenreResponse getGenre(
//            @PathVariable("id")
//            UUID id);
//
//    @PutMapping("/api/genres/{id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    @ResponseBody
//    void putGenre(
//            @PathVariable("id")
//            UUID id,
//            @RequestBody
//            PutGenreRequest request);
//
//    @DeleteMapping("/api/genres/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteGenre(
            @PathVariable("id")
            UUID id);

//    @PatchMapping("/api/genres/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    void patchGenre(
//            @PathVariable("id")
//            UUID id,
//            @RequestBody
//            PutGenreRequest request);
}
