package pl.edu.pg.aui.lab2.function;

import org.springframework.stereotype.Component;
import pl.edu.pg.aui.lab2.dtos.PatchMovieRequest;
import pl.edu.pg.aui.lab2.entities.Movie;

import java.util.function.BiFunction;

@Component
public class UpdateMovieWithRequestFunction implements BiFunction<Movie, PatchMovieRequest, Movie> {

    @Override
    public Movie apply(Movie entity, PatchMovieRequest request) {
//        if (request.getTitle() == null) {
//            request.setTitle(entity.getTitle());
//        }
//
//        if (request.getDirector() == null) {
//            request.setDirector(entity.getDirector());
//        }
        return Movie.builder()
                .id(entity.getId())
                .title(request.getTitle())
                .director(request.getDirector())
                .releaseYear(entity.getReleaseYear())
                .genre(entity.getGenre())
                .build();
    }
}
