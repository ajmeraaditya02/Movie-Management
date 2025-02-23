package Backend.Movie_Management.Service;

import Backend.Movie_Management.Entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieServicesInterface {
    public List<Movie> getAllMovies();
    public Optional<Movie> getMovieById(Long Id);
    public Optional<Movie> getMovieByTitle(String title);
    public List<Movie> getMovieByGenre(String genre);
    public List<Movie> getMovieByReleaseYear(int releaseYear);
    public List<Movie> getMovieByDirector(String Director);
    public void addMovie(Movie movie);
    public void deleteMovieById(Long Id);
    public void deleteMovieByTitle(String title);
    public void updateMovieTitle(String title, String newTitle);
    public void updateMovieGenre(String title, String newGenre);
    public void updateMovieDirector(String title, String newDirector);
    public void updateMovieReleaseYear(String title, String newReleaseYear);
    public void updateMovieRating(String title, String newRating);
    public List<Movie> getTopNMovies(int n);
}
