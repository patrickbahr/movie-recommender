package br.furb.movies.domain.nodes;

import static lombok.AccessLevel.PRIVATE;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = PRIVATE)
@NodeEntity("Genres")
public class Genre {
	
	@Id
	private String genres;
}
