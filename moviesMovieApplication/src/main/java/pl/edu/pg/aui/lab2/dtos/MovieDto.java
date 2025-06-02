//package pl.edu.pg.aui.lab2.dtos;
//
//import lombok.*;
//
//@Builder
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper=false)
//@ToString
//
//public class MovieDto implements Comparable<MovieDto> {
//    private String title;
//    private String director;
//    private Integer releaseYear;
//    private String genre;
//
//    @Override
//    public int compareTo(MovieDto other) {
//        if (this.title.compareTo(other.title) != 0) {
//            return this.title.compareTo(other.title);
//        } else if (this.releaseYear.compareTo(other.releaseYear) != 0) {
//            return this.releaseYear.compareTo(other.releaseYear);
//        } else {
//            return this.director.compareTo(other.director);
//        }
//    }
//}
