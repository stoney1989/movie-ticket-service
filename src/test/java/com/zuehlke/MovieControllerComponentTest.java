package com.zuehlke;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerComponentTest {
	
	@Autowired
	MovieController controller;

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

	@Test
    public void getMovies() throws Exception {
    	ArrayList<SimpleMovie> movies = controller.getMovies();
    	ArrayList<Integer> ids = new ArrayList<>();
    	for (SimpleMovie simpleMovie : movies) {
			ids.add((int) simpleMovie.getId());
		}
    	when().get("/api/v1/movies").then().statusCode(200).body("id", hasItems(1,2,3));
    }

    @Test
    public void getMovieById() throws Exception {
    	ArrayList<SimpleMovie> movies = controller.getMovies();
    	for (SimpleMovie simpleMovie : movies) {
    		Movie movie = controller.getMovie(simpleMovie.getId());
    		when().get("/api/v1/movies/"+movie.getId()).then().statusCode(200)
    		.body("id", equalTo((int)movie.getId()))
    		.body("title", equalTo(movie.getTitle()))
    		.body("poster", equalTo(movie.getPoster()))
    		.body("plot", equalTo(movie.getPlot()))
    		.body("year", equalTo(movie.getYear()));
		}
    }

}