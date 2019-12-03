package br.furb.movies.domain.pojo;

import org.springframework.data.neo4j.annotation.QueryResult;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@QueryResult
public class RecommendationForUser {
	
	private String genres;
	private Float rating;
	private String title;
	private Long userId;
	
}
