package pl.edu.pg.aui.lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${movies.movie.url}") String movieUrl,
			@Value("${movies.genre.url}") String genreUrl,
			@Value("${movies.gateway.host}") String host) {
		return builder
				.routes()
				.route("genres", route -> route
						.host(host)
						.and()
						.path(
								"/api/genres/{uuid}",
								"/api/genres")
						.uri(genreUrl))
				.route("movies", route -> route
						.host(host)
						.and()
						.path(
								"/api/movies",
								"/api/movies/**",
								"/api/genres/{uuid}",
								"/api/genres/{uuid}/movies"
						// "/api/genres/{uuid}/movies/**"
						)
						.uri(movieUrl))
				.build();
	}

}
