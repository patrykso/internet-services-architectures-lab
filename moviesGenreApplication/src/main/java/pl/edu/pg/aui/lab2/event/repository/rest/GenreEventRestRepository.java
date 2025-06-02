package pl.edu.pg.aui.lab2.event.repository.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import pl.edu.pg.aui.lab2.event.repository.api.GenreEventRepository;

import java.util.UUID;

@Repository
public class GenreEventRestRepository implements GenreEventRepository {

    private final RestTemplate restTemplate;

    @Autowired
    public GenreEventRestRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void delete(UUID genreId) {
        // restTemplate.delete("http://localhost:8080/api/genres/" + genreId);
        // restTemplate.delete("/api/genres/{uuid}", genreId);
        // restTemplate.delete("/api/genres/{uuid}", genreId);
        restTemplate.delete("/api/movies/genre/{uuid}", genreId);

    }
}