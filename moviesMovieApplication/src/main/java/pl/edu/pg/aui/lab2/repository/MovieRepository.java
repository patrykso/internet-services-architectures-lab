package pl.edu.pg.aui.lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pg.aui.lab2.entities.Genre;
import pl.edu.pg.aui.lab2.entities.Movie;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findAllByGenre(Genre genre);
}
