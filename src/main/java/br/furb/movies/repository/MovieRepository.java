package br.furb.movies.repository;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.furb.movies.domain.nodes.Movie;
import br.furb.movies.domain.pojo.MovieWatchedByUser;
import br.furb.movies.domain.pojo.RecommendationForUser;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

	Movie findByTitle(@Param("title") String title);

	@Query("MATCH (n:Movies) WHERE n.title contains {title} RETURN n")
	Collection<Movie> findByTitleLike(@Param("title") String title);

	@Query("MATCH (u:Users)-[w:WATCHED]->(m1:Movies) WHERE u.userId ={userId} RETURN u.userId as userId, m1.title as title, toFloat(w.rating) as rating")
	Collection<MovieWatchedByUser> watchedByUser(@Param("userId") Long userId);
	
	@Query("MATCH (u1:Users)-[:WATCHED]->(m3:Movies) WHERE u1.userId ={userId} WITH [i in m3.movieId | i] as movies MATCH path = (u:Users)-[:WATCHED]->(m1:Movies)-[s:SIMILAR]->(m2:Movies), (m2)-[:GENRES]->(g:Genres), (u)-[:FAVORITE]->(g) WHERE u.userId ={userId} and not m2.movieId in movies \r\n" + 
			"RETURN distinct u.userId as userId, g.genres as genres,  m2.title as title, m2.rating_mean as rating ORDER BY m2.rating_mean descending LIMIT 5")
	Collection<RecommendationForUser> recommendedForUser(@Param("userId") Long userId);
}