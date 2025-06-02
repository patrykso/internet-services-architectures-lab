package pl.edu.pg.aui.lab2.services;

import pl.edu.pg.aui.lab2.entities.Movie;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieService {
    Optional<Movie> find(UUID id);
    List<Movie> findAll();
    void create(Movie movie);
    void update(Movie movie);
    void delete(UUID id);
    Optional<List<Movie>> findAllByGenre(UUID genreId);
}
