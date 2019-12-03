package br.furb.movies.controller;

import java.util.Collection;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.furb.movies.domain.nodes.Movie;
import br.furb.movies.domain.pojo.MovieWatchedByUser;
import br.furb.movies.domain.pojo.RecommendationForUser;
import br.furb.movies.service.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private final MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/findByTitle")
	public ResponseEntity<Movie> findByTitle(@RequestParam(value = "title", required = true) String title) {

		Movie movieFound = movieService.findByTitle(title);
		if (movieFound != null) {
			return new ResponseEntity<Movie>(movieFound, HttpStatus.OK);
		}
		return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/findByTitleLike")
	public ResponseEntity<Collection<Movie>> findByTitleLike(
			@RequestParam(value = "title", required = true) String title) {

		Collection<Movie> movies = movieService.findByTitleLike(title);
		if (!CollectionUtils.isEmpty(movies)) {
			return new ResponseEntity<Collection<Movie>>(movies, HttpStatus.OK);
		}
		return new ResponseEntity<Collection<Movie>>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/watchedByUser")
	public ResponseEntity<Collection<MovieWatchedByUser>> watchedByUser(
			@RequestParam(value = "userId", required = true) Long userId) {
		Collection<MovieWatchedByUser> movies = movieService.watchedByUser(userId);
		if (Objects.nonNull(movies)) {
			return new ResponseEntity<>(movies, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/recommendedForUser")
	public ResponseEntity<Collection<RecommendationForUser>> recommendedForUser(
			@RequestParam(value = "userId", required = true) Long userId) {
		Collection<RecommendationForUser> movies = movieService.recommendedForUser(userId);
		if (Objects.nonNull(movies)) {
			return new ResponseEntity<>(movies, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}