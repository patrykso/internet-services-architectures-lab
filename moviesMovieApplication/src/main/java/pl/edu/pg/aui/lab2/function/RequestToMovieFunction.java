package pl.edu.pg.aui.lab2.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.aui.lab2.dtos.PutMovieRequest;
import pl.edu.pg.aui.lab2.entities.Movie;
import pl.edu.pg.aui.lab2.entities.Genre;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToMovieFunction implements BiFunction<UUID, PutMovieRequest, Movie> {

    @Override
    public Movie apply(UUID id, PutMovieRequest request) {
        return Movie.builder()
                .id(id)
                .title(request.getTitle())
                .releaseYear(request.getReleaseYear())
                .director(request.getDirector())
                .genre(Genre.builder()
                        .id(request.getGenreId())
                        .build())
                .build();
    }
}
