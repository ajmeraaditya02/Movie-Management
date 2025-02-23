package Backend.Movie_Management.Service;

import Backend.Movie_Management.Entity.Movie;
import Backend.Movie_Management.Repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServices implements MovieServicesInterface{
    @Autowired
    MovieRepo movieRepo;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movie> getMovieById(Long id) {
        return movieRepo.findById(id);
    }

    @Override
    public Optional<Movie> getMovieByTitle(String title){
        return movieRepo.findByTitle(title);
    }

    @Override
    public List<Movie> getMovieByGenre(String genre){
        return movieRepo.findByGenre(genre);
    }

    @Override
    public List<Movie> getMovieByReleaseYear(int releaseYear){
        return movieRepo.findByReleaseYear(releaseYear);
    }

    @Override
    public List<Movie> getMovieByDirector(String director){
        return movieRepo.findByDirector(director);
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepo.save(movie);
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepo.deleteById(id);
    }

    @Override
    public void deleteMovieByTitle(String title) {
        movieRepo.deleteByTitle(title);
    }

    @Override
    public void updateMovieDirector(String title, String newDirector) {
        movieRepo.updateDirector(title, newDirector);
    }

    @Override
    public void updateMovieGenre(String title, String newGenre) {
        movieRepo.updateGenre(title, newGenre);
    }

    @Override
    public void updateMovieRating(String title, String newRating) {
        movieRepo.updateRating(title, newRating);
    }

    @Override
    public void updateMovieReleaseYear(String title, String newReleaseYear) {
        movieRepo.updateReleaseYear(title, newReleaseYear);
    }

    @Override
    public void updateMovieTitle(String title, String newTitle) {
        movieRepo.updateTitle(title, newTitle);
    }

    @Override
    public List<Movie> getTopNMovies(int n) {
        return movieRepo.getTopMovies(n);
    }
}

