package br.furb.movies.domain.nodes;

import static lombok.AccessLevel.PRIVATE;

import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import br.furb.movies.domain.relationships.UsersGenres;
import br.furb.movies.domain.relationships.UsersMovies;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = PRIVATE)
@NodeEntity("Users")
public class User {

    @Id
    @GeneratedValue
	private Long userId;

    @Relationship(type = "WATCHED")
    private Set<UsersMovies> usersMovies;
    
    @Relationship(type = "FAVORITE")
    private Set<UsersGenres> usersGenres;
    
	public User(Long userId) {
		super();
		this.userId = userId;
	}
    
}
