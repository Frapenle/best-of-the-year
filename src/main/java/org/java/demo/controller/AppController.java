package org.java.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.demo.pojo.Movie;
import org.java.demo.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {
	private String name = "Francesco";
	@GetMapping("/")
	public String getTitle(Model model) {
		model.addAttribute("name", name);
		
		return "index";
	}
//	MOVIES
	private List<Movie> getBestMovies(Model model){
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1, "Il padrino"));
		movies.add(new Movie(2, "Le ali della libertà"));
		movies.add(new Movie(3, "Taxi driver"));
		model.addAttribute("movies", movies);
		return movies;
	}

	@GetMapping("/movies")
	public String getMovieTitles(Model model) {
	    List<Movie> movies = getBestMovies(model);
//	    String titles = "";
//	    for (int i = 0; i < movies.size(); i++) {
//	        titles += movies.get(i).getTitle();
//	        if (i < movies.size() - 1) {
//	            titles += ", ";
//	        } else { titles += ".";}
//	    }
	    model.addAttribute("movies", movies);
	    model.addAttribute("pageTitle", "Movies List");
	    return "movies";
	}
	@GetMapping("/movies/{id}")
	public String getMovieById(Model model,
			@PathVariable("id") int id) {
	    Movie movie = null;
		for (Movie mov : getBestMovies(model)) {
			if (mov.getId() == id) {
				movie = mov;
			}
		}
		model.addAttribute("movie", movie);
		model.addAttribute("pageTitle", "Movie");
		return "movie";
	}
	
//	SONGS
	private List<Song> getBestSongs(Model model){
		List<Song> songs = new ArrayList<>();
		songs.add(new Song(1, "Another Brick in the Wall"));
		songs.add(new Song(2, "The Scientist"));
		songs.add(new Song(3, "Highway Star"));
		model.addAttribute("songs", songs);
		return songs;
	}
	@GetMapping("/songs")
	public String getSongTitles(Model model) {
	    List<Song> songs = getBestSongs(model);
//	    String titles = "";
//	    for (int i = 0; i < songs.size(); i++) {
//	        titles += songs.get(i).getTitle();
//	        if (i < songs.size() - 1) {
//	            titles += ", ";
//	        } else { titles += ".";}
//	    }
	    model.addAttribute("songs", songs);
	    model.addAttribute("pageTitle", "Songs List");
	    return "songs";
	}
	@GetMapping("/songs/{id}")
	public String getSongById(Model model,
			@PathVariable("id") int id) {
		Song song = null;
		for (Song s : getBestSongs(model)) {
			if (s.getId() == id) {
				song = s;
			}
		}
		model.addAttribute("song", song);
		model.addAttribute("pageTitle", "Song");
		return "song";
	}
}
