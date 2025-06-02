package pl.edu.pg.aui.lab2.services;

import pl.edu.pg.aui.lab2.entities.Genre;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GenreService {
    Optional<Genre> find(UUID id);
    void create(Genre genre);
    List<Genre> findAll();
    void delete(UUID id);
}
