package Backend.Movie_Management.Controller;

import Backend.Movie_Management.Entity.Movie;
import Backend.Movie_Management.Service.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieControllers {

    @Autowired
    MovieServices movieServices;

    @GetMapping("/all")
    public List<Movie> getAllMovies(){
        System.out.println("Yupp1");
        return movieServices.getAllMovies();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable Long id){
        return movieServices.getMovieById(id);
    }

    @GetMapping("/{title}")
    public Optional<Movie> getMovieByTitle(@PathVariable String title){
        return movieServices.getMovieByTitle(title);
    }

    @GetMapping("/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable String genre){
        return movieServices.getMovieByGenre(genre);
    }

    @GetMapping("/{releaseYear}")
    public List<Movie> getMoviesByReleaseYear(@PathVariable int releaseYear){
        return movieServices.getMovieByReleaseYear(releaseYear);
    }

    @GetMapping("/{director}")
    public List<Movie> getMoviesByDirector(@PathVariable String director){
        return movieServices.getMovieByDirector(director);
    }

    @PostMapping("/add")
    public void addMovie(@RequestBody Movie movie){
        System.out.println("Yes: " + movie);
        movieServices.addMovie(movie);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMovieById(@PathVariable Long id){
        movieServices.deleteMovieById(id);
    }

    @DeleteMapping("/delete")
    public void deleteMovieByTitle(String title){
        System.out.println("yupp!!!");
        movieServices.deleteMovieByTitle(title);
    }

    @PutMapping("update/{title}/title")
    public void updateMovieTitle(@PathVariable String title, String newTitle){
        movieServices.updateMovieTitle(title, newTitle);
    }

    @PutMapping("update/{title}/genre")
    public void updateMovieGenre(@PathVariable String title, String newGenre){
        movieServices.updateMovieGenre(title, newGenre);
    }

    @PutMapping("update/{title}/director")
    public void updateMovieDirector(@PathVariable String title, String newDirector){
        movieServices.updateMovieDirector(title, newDirector);
    }

    @PutMapping("update/{title}/releaseYear")
    public void updateMovieReleaseYear(@PathVariable String title, String newReleaseYear){
        movieServices.updateMovieReleaseYear(title, newReleaseYear);
    }

    @PutMapping("update/{title}/rating")
    public void updateMovieRating(@PathVariable String title, String newRating){
        movieServices.updateMovieRating(title, newRating);
    }

    @GetMapping("/top/{n}")
    public void getTopNMovies(@PathVariable int n){
        movieServices.getTopNMovies(n);
    }

}
