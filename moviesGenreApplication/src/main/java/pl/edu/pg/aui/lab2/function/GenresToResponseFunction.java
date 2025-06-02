package pl.edu.pg.aui.lab2.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.aui.lab2.dtos.GetGenresResponse;
import pl.edu.pg.aui.lab2.entities.Genre;

import java.util.List;
import java.util.function.Function;

@Component
public class GenresToResponseFunction implements Function <List<Genre>, GetGenresResponse> {
    @Override
    public GetGenresResponse apply(List<Genre> entities) {
        return GetGenresResponse.builder()
                .genres(entities.stream()
                        .map(Genre -> GetGenresResponse.Genre.builder()
                                .id(Genre.getId())
                                .name(Genre.getName())
                                .build())
                        .toList())
                .build();
    }
}
