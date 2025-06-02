package pl.edu.pg.aui.lab2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pg.aui.lab2.entities.Genre;
import pl.edu.pg.aui.lab2.repository.GenreRepository;
import pl.edu.pg.aui.lab2.event.repository.api.GenreEventRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GenreDefaultService implements GenreService {
    private final GenreRepository genreRepository;
    private final GenreEventRepository eventRepository;

    @Autowired
    public GenreDefaultService(GenreRepository genreRepository, GenreEventRepository eventRepository) {
        this.genreRepository = genreRepository;
        this.eventRepository = eventRepository;
    }

    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> find(UUID id) {
        return genreRepository.findById(id);
    }

    @Override
    public void create(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void delete(UUID id) {
        // genreRepository.deleteById(id);
        // genreRepository.findById(id).ifPresent(genreRepository::delete);
        // eventRepository.delete(id);
        genreRepository.findById(id).ifPresent(genre -> {
            genreRepository.delete(genre);
            eventRepository.delete(id);
        });
    }
}
