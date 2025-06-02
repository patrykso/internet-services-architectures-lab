package pl.edu.pg.aui.lab2.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor()
@ToString
@EqualsAndHashCode

public class PatchMovieRequest {
    private String title;
    private String director;
//    private Integer releaseYear; # for the purpose of this lab class - changing release year is not allowed
}
