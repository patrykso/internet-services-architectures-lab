package pl.edu.pg.aui.lab2.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.aui.lab2.dtos.PutGenreRequest;
import pl.edu.pg.aui.lab2.entities.Genre;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToGenreFunction implements BiFunction<UUID, PutGenreRequest, Genre> {
    @Override
    public Genre apply(UUID id, PutGenreRequest request) {
        return Genre.builder()
                .id(id)
                .name(request.getName())
                .build();
    }
}
