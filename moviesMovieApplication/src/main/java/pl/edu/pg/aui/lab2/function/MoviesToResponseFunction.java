package pl.edu.pg.aui.lab2.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.aui.lab2.dtos.GetMoviesResponse;
import pl.edu.pg.aui.lab2.entities.Movie;

import java.util.List;
import java.util.function.Function;

@Component
public class MoviesToResponseFunction implements Function<List<Movie>, GetMoviesResponse> {

    @Override
    public GetMoviesResponse apply(List<Movie> entities) {
        return GetMoviesResponse.builder()
                .movies(entities.stream()
                        .map(movie -> GetMoviesResponse.Movie.builder()
                                .id(movie.getId())
                                .title(movie.getTitle())
                                .releaseYear(movie.getReleaseYear())
                                .director(movie.getDirector())
                                .genre(movie.getGenre().getName())
                                .build())
                        .toList())
                .build();
    }
}


