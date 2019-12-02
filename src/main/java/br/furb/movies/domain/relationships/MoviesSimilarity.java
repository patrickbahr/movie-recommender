package br.furb.movies.domain.relationships;

import static lombok.AccessLevel.PRIVATE;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import br.furb.movies.domain.nodes.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = PRIVATE)
@RelationshipEntity(type = "SIMILAR")
public class MoviesSimilarity {
	
	@StartNode
	private Movie movie;
	
	@EndNode
	@Property(name = "sim_movieId")
	private Movie similarMovie;
	
	private String relevance;

}
