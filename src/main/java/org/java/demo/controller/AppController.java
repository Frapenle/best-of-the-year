package org.java.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.demo.obj.Movie;
import org.java.demo.obj.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	private String name = "Francesco";
	@GetMapping("/")
	public String getTitle(Model model) {
		model.addAttribute("name", name);
		
		return "index";
	}
//	MOVIES
	private List<Movie> getBestMovies(){
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1, "Il padrino"));
		movies.add(new Movie(2, "Le ali della libertà"));
		movies.add(new Movie(3, "Taxi driver"));
		return movies;
	}
	@GetMapping("/movies")
	public String getMovieTitles(Model model) {
	    List<Movie> movies = getBestMovies();
	    String titles = "";
	    for (int i = 0; i < movies.size(); i++) {
	        titles += movies.get(i).getTitle();
	        if (i < movies.size() - 1) {
	            titles += ", ";
	        } else { titles += ".";}
	    }
	    model.addAttribute("movies", titles);
	    return "movies";
	}
	
//	SONGS
	private List<Song> getBestSongs(){
		List<Song> songs = new ArrayList<>();
		songs.add(new Song(1, "Another Brick in the Wall"));
		songs.add(new Song(2, "The Scientist"));
		songs.add(new Song(3, "Highway Star"));
		return songs;
	}
	@GetMapping("/songs")
	public String getSongTitles(Model model) {
	    List<Song> songs = getBestSongs();
	    String titles = "";
	    for (int i = 0; i < songs.size(); i++) {
	        titles += songs.get(i).getTitle();
	        if (i < songs.size() - 1) {
	            titles += ", ";
	        } else { titles += ".";}
	    }
	    model.addAttribute("songs", titles);
	    return "songs";
	}
	
	

}
