package pl.edu.pg.aui.lab2.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.aui.lab2.entities.Movie;
import pl.edu.pg.aui.lab2.dtos.GetMovieResponse;

import java.util.function.Function;


@Component
public class MovieToResponseFunction implements Function<Movie, GetMovieResponse> {

    @Override
    public GetMovieResponse apply(Movie entity) {
        return GetMovieResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .releaseYear(entity.getReleaseYear())
                .director(entity.getDirector())
                .genre(GetMovieResponse.Genre.builder()
                        .id(entity.getGenre().getId())
//                        .name(entity.getGenre().getName())
                        .build())
                .build();
    }
}
