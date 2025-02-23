package Backend.Movie_Management.Repository;

import Backend.Movie_Management.Entity.Movie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
    @Query("SELECT title,director,genre,releaseYear,rating" +
            " FROM Movie WHERE title = :title")
    Optional<Movie> findByTitle(@Param("title") String title);

    @Query("SELECT title,director,genre,releaseYear,rating" +
            " FROM Movie WHERE genre = :genre")
    List<Movie> findByGenre(@Param("genre") String genre);

    @Query("SELECT title,director,genre,releaseYear,rating" +
            " FROM Movie WHERE releaseYear = :releaseYear")
    List<Movie> findByReleaseYear(@Param("releaseYear") int releaseYear);

    @Query("SELECT title,director,genre,releaseYear,rating" +
            " FROM Movie WHERE director = :director")
    List<Movie> findByDirector(@Param("director") String director);

    @Transactional
    @Modifying
    @Query("Delete FROM Movie WHERE title = :title")
    void deleteByTitle(@Param("title") String title);

    @Transactional
    @Modifying
    @Query("UPDATE Movie SET director = :newDirector WHERE title = :title")
    void updateDirector(@Param("title") String title,@Param("newDirector") String newDirector);

    @Transactional
    @Modifying
    @Query("UPDATE Movie SET title = :newTitle WHERE title = :title")
    void updateTitle(@Param("title") String title,@Param("newTitle") String newTitle);

    @Transactional
    @Modifying
    @Query("UPDATE Movie SET rating = :newRating WHERE title = :title")
    void updateRating(@Param("title") String title,@Param("newRating") String newRating);

    @Transactional
    @Modifying
    @Query("UPDATE Movie SET genre = :newGenre WHERE title = :title")
    void updateGenre(@Param("title") String title,@Param("newGenre") String newGenre);

    @Transactional
    @Modifying
    @Query("UPDATE Movie SET releaseYear = :newReleaseYear WHERE title = :title")
    void updateReleaseYear(@Param("title") String title,@Param("newReleaseYear") String newReleaseYear);

    @Transactional
    @Query("SELECT title,director,genre,releaseYear,rating FROM Movie" +
            " ORDER BY rating DESC" +
            " LIMIT :n")
    List<Movie> getTopMovies(@Param("n") int n);
}
