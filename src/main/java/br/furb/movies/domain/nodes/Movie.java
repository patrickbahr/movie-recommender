package br.furb.movies.domain.nodes;

import static lombok.AccessLevel.PRIVATE;

import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.furb.movies.domain.relationships.MoviesGenres;
import br.furb.movies.domain.relationships.MoviesSimilarity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor(access = PRIVATE)
@NodeEntity("Movies")
public class Movie {
	
	@Id
	@GeneratedValue
	private Long movieId;
	
	private String title;

	@Property(name = "rating_mean")
	private Float ratingMean;
	
	@JsonIgnore
	@Relationship(type = "GENRES")
	private Set<MoviesGenres> moviesGenres;
	
	@JsonIgnore
	@Relationship(type = "SIMILAR")
	private Set<MoviesSimilarity> moviesSimilarity;
	
}
