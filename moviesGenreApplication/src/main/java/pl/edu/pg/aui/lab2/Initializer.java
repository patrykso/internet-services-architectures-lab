package pl.edu.pg.aui.lab2;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.pg.aui.lab2.entities.Genre;
import pl.edu.pg.aui.lab2.services.GenreService;

import java.util.UUID;

@Component
public class Initializer implements InitializingBean {
    private final GenreService genreService;

    @Autowired
    public Initializer(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    public void afterPropertiesSet() {
        Genre horror = Genre.builder()
                .id(UUID.fromString("681a88be-79f8-472f-98cf-30c2e83175a6"))
                .name("Horror")
                .build();

        Genre drama = Genre.builder()
                .id(UUID.fromString("91124165-92b8-46a1-8097-84d1c021641d"))
                .name("Drama")
                .build();

        Genre action = Genre.builder()
                .id(UUID.fromString("d5d3e706-c3d4-4e3d-b4a9-3bf32ddc6a8f"))
                .name("Action")
                .build();

        genreService.create(horror);
        genreService.create(drama);
        genreService.create(action);
    }
}
