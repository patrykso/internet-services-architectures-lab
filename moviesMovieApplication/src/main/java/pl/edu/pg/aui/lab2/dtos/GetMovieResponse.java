package pl.edu.pg.aui.lab2.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor()
@ToString
@EqualsAndHashCode
public class GetMovieResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor()
    @ToString
    @EqualsAndHashCode
    public static class Genre {
        private UUID id;
        private String name;
    }

    private UUID id;
    private String title;
    private String director;
    private Integer releaseYear;
    private Genre genre;
}
