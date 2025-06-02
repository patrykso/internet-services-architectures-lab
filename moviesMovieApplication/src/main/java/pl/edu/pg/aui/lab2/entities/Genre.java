package pl.edu.pg.aui.lab2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "genres")
public class Genre implements Comparable<Genre>, Serializable {
    @Id
    private UUID id;
    // private String name;
    @OneToMany(mappedBy = "genre", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Movie> movies;

    // public void addMovie(Movie object) {
    // if (movies == null) {
    // movies = new ArrayList<>();
    // }
    // movies.add(object);
    // }

    @Override
    public int compareTo(Genre other) {
        if (this.id.equals(other.id)) {
            return 0;
        } else {
            return this.id.compareTo(other.id);
        }
    }

    public String getName() {
        return this.id.toString();
    }

    // public List<Movie> getMovies() {
    // return movies;
    // }
    //
    // public void setMovies(List<Movie> movies) {
    // this.movies = movies;
    // }
}
