package pl.edu.pg.aui.lab2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.aui.lab2.entities.Movie;
import pl.edu.pg.aui.lab2.repository.GenreRepository;
import pl.edu.pg.aui.lab2.repository.MovieRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieDefaultService implements MovieService {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public MovieDefaultService(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public Optional<Movie> find(UUID id) {
        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public void create(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    //TODO: Implement update method
    public void update(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void delete(UUID id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Optional<List<Movie>> findAllByGenre(UUID genreId) {
        return genreRepository.findById(genreId)
                .map(movieRepository::findAllByGenre);
    }
}
