package br.furb.movies.service;

import java.util.Collection;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.furb.movies.domain.nodes.Movie;
import br.furb.movies.domain.pojo.MovieWatchedByUser;
import br.furb.movies.domain.pojo.RecommendationForUser;
import br.furb.movies.repository.MovieRepository;

@Service
public class MovieService {

	private final MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Transactional(readOnly = true)
	public Movie findByTitle(@NonNull String title) {
		Movie result = movieRepository.findByTitle(title);
		return result;
	}

	@Transactional(readOnly = true)
	public Collection<Movie> findByTitleLike(@NonNull String title) {
		Collection<Movie> result = movieRepository.findByTitleLike(title);
		return result;
	}

	@Transactional(readOnly = true)
	public Collection<MovieWatchedByUser> watchedByUser(@NonNull Long userId) {
		Collection<MovieWatchedByUser> movies = movieRepository.watchedByUser(userId);
		return movies;
	}
	
	public Collection<RecommendationForUser> recommendedForUser(@NonNull Long userId) {
		Collection<RecommendationForUser> recommendations = movieRepository.recommendedForUser(userId);
		return recommendations;		
	}

}