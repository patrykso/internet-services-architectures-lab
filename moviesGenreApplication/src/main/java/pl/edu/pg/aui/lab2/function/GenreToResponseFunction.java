package pl.edu.pg.aui.lab2.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.aui.lab2.dtos.GetGenreResponse;
import pl.edu.pg.aui.lab2.entities.Genre;

import java.util.function.Function;

@Component
public class GenreToResponseFunction implements Function<Genre, GetGenreResponse> {

    @Override
    public GetGenreResponse apply(Genre entity) {
        return GetGenreResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
