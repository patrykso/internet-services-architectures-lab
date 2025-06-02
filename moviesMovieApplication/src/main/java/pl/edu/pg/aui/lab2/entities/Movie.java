package pl.edu.pg.aui.lab2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString()
@EqualsAndHashCode()
@Entity
@Table(name = "movies")

public class Movie implements Comparable<Movie>, Serializable {
    @Id
    private UUID id;
    private String title;
    private String director;
    private Integer releaseYear;
    // @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @Override
    public int compareTo(Movie other) {
        if (this.title.compareTo(other.title) != 0) {
            return this.title.compareTo(other.title);
        } else if (this.releaseYear.compareTo(other.releaseYear) != 0) {
            return this.releaseYear.compareTo(other.releaseYear);
        } else {
            return this.director.compareTo(other.director);
        }
    }
}
