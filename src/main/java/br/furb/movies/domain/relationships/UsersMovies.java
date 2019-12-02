package br.furb.movies.domain.relationships;

import static lombok.AccessLevel.PRIVATE;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import br.furb.movies.domain.nodes.Movie;
import br.furb.movies.domain.nodes.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor(access = PRIVATE)
@RelationshipEntity(type = "WATCHED")
public class UsersMovies {
	
	@StartNode
	private User user;
	
	@EndNode
	private Movie movie;
	
	private String rating;

}
