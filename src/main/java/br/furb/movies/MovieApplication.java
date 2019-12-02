package br.furb.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("br.furb.movies.repository")
public class MovieApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

}
