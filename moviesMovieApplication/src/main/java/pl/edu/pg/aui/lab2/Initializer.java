package pl.edu.pg.aui.lab2;

import jakarta.annotation.PostConstruct;
import lombok.extern.java.Log;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.aui.lab2.entities.Genre;
import pl.edu.pg.aui.lab2.entities.Movie;
import pl.edu.pg.aui.lab2.services.GenreService;
import pl.edu.pg.aui.lab2.services.MovieService;

import java.util.LinkedList;
import java.util.UUID;

@Log
@Component
public class Initializer implements InitializingBean {

    private final MovieService movieService;
    private final GenreService genreService;

    @Autowired
    public Initializer(MovieService movieService, GenreService genreService) {
        this.movieService = movieService;
        this.genreService = genreService;
    }

    @Override
    public void afterPropertiesSet() {
        Genre horror = Genre.builder()
                .id(UUID.fromString("681a88be-79f8-472f-98cf-30c2e83175a6"))
                .build();

        Genre drama = Genre.builder()
                .id(UUID.fromString("91124165-92b8-46a1-8097-84d1c021641d"))
                .build();

        Genre action = Genre.builder()
                .id(UUID.fromString("d5d3e706-c3d4-4e3d-b4a9-3bf32ddc6a8f"))
                .build();

        genreService.create(horror);
        genreService.create(drama);
        genreService.create(action);

        Movie movie1 = Movie.builder()
                // id is random characters
                .id(UUID.fromString("486f62cb-2a22-4a62-a10e-39baa9bf40e5"))
                .title("American Psycho")
                .releaseYear(2000)
                .director("Mary Harron")
                .genre(horror)
                .build();

        Movie movie2 = Movie.builder()
                .id(UUID.fromString("37f983f0-5baa-4d6c-b683-756fa316f247"))
                .title("The Shining")
                .releaseYear(1980)
                .director("Stanley Kubrick")
                .genre(horror)
                .build();

        Movie movie3 = Movie.builder()
                .id(UUID.fromString("35572a91-5e76-454d-b87b-ba28a7c8e936"))
                .title("I Am Legend")
                .releaseYear(2007)
                .director("Francis Lawrence")
                .genre(horror)
                .build();

        Movie movie4 = Movie.builder()
                .id(UUID.fromString("1f6d6517-6dc1-4f38-96eb-fe418df1e4d4"))
                .title("Forrest Gump")
                .releaseYear(1994)
                .director("Robert Zemeckis")
                .genre(drama)
                .build();

        Movie movie5 = Movie.builder()
                .id(UUID.fromString("285a7b66-7778-4a4f-aeb4-079e75e612fe"))
                .title("The Shawshank Redemption")
                .releaseYear(1994)
                .director("Frank Darabont")
                .genre(drama)
                .build();

        Movie movie6 = Movie.builder()
                .id(UUID.fromString("04443f61-1f6e-4447-a81d-9d91b3069a00"))
                .title("Fight Club")
                .releaseYear(1999)
                .director("David Fincher")
                .genre(drama)
                .build();

        Movie movie7 = Movie.builder()
                .id(UUID.fromString("07de98df-12a7-4556-9edf-8fd33a48301b"))
                .title("The Dark Knight")
                .releaseYear(2008)
                .director("Christopher Nolan")
                .genre(action)
                .build();

        Movie movie8 = Movie.builder()
                .id(UUID.fromString("74d7ec09-fb1c-4a04-8e49-ceb0d242fba6"))
                .title("Matrix")
                .releaseYear(1999)
                .director("Wachowski Sisters")
                .genre(action)
                .build();

        Movie movie9 = Movie.builder()
                .id(UUID.fromString("b4c2d75b-5e37-4b8b-9075-ddd1ce3b3198"))
                .title("Inception")
                .releaseYear(2010)
                .director("Christopher Nolan")
                .genre(action)
                .build();

//        horror.addMovie(movie1);
//        horror.addMovie(movie2);
//        horror.addMovie(movie3);
//        drama.addMovie(movie4);
//        drama.addMovie(movie5);
//        drama.addMovie(movie6);
//        action.addMovie(movie7);
//        action.addMovie(movie8);
//        action.addMovie(movie9);
        movieService.create(movie1);
        movieService.create(movie2);
        movieService.create(movie3);
        movieService.create(movie4);
        movieService.create(movie5);
        movieService.create(movie6);
        movieService.create(movie7);
        movieService.create(movie8);
        movieService.create(movie9);
    }
}
