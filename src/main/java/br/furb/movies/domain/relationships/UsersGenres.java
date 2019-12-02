package br.furb.movies.domain.relationships;

import static lombok.AccessLevel.PRIVATE;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import br.furb.movies.domain.nodes.Genre;
import br.furb.movies.domain.nodes.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = PRIVATE)
@RelationshipEntity(type = "FAVORITE")
public class UsersGenres {
	
	
	@StartNode
	private User user;
	
	@EndNode
	private Genre genres;

}
