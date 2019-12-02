package br.furb.movies.service;

import java.util.Collection;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.furb.movies.domain.nodes.Movie;
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
	public Collection<Movie> recommendationForUser(@NonNull Long userId, @NonNull int limit) {
		Collection<Movie> result = movieRepository.recommendationForUser(userId, limit);
		return result;
	}

	@Transactional(readOnly = true)
	public HttpResponse<String> recommendationForUser(@NonNull Long userId) {
		HttpResponse<String> response = null;
		try {
			response = Unirest.post("http://localhost:7474/db/data/cypher").header("content-type", "application/json")
					.header("authorization", "Basic bmVvNGo6cm9vdA==")
					.body("{\n  \"query\" : \"MATCH (u1:Users)-[:WATCHED]->(m3:Movies) WHERE u1.userId =4 WITH [i in m3.movieId | i] as movies MATCH path = (u:Users)-[:WATCHED]->(m1:Movies)-[s:SIMILAR]->(m2:Movies), (m2)-[:GENRES]->(g:Genres), (u)-[:FAVORITE]->(g) WHERE u.userId =4 and not m2.movieId in movies RETURN distinct u.userId as userId, g.genres as genres,  m2.title as title, m2.rating_mean as rating ORDER BY m2.rating_mean descending LIMIT 5\",\n  \"params\" : {\n   \n  }\n}")
					.asString();
		} catch (UnirestException e) {
		}
		return response;
		// return recommendationForUser(userId, 5);
	}
}