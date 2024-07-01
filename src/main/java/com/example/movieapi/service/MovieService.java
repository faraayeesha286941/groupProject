package com.example.movieapi.service;

import com.example.movieapi.model.Movie;
import com.example.movieapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movieDetails) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            Movie movie = movieOptional.get();
            movie.setTitle(movieDetails.getTitle());
            movie.setReleaseYear(movieDetails.getReleaseYear());
            movie.setGenres(movieDetails.getGenres());
            movie.setImdbRating(movieDetails.getImdbRating());
            movie.setLengthInMin(movieDetails.getLengthInMin());
            movie.setPoster(movieDetails.getPoster());
            return movieRepository.save(movie);
        }
        return null;
    }

    public List<Movie> searchMovies(String query) {
        // This is a basic implementation. You might want to refine it based on your needs.
        return movieRepository.findByTitleContainingIgnoreCase(query);
    }

}
