package br.furb.movies.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import br.furb.movies.domain.nodes.Genre;

public interface GenreRepository extends Neo4jRepository<Genre, String> {
	
	Genre findByGenres(String genres);

}
