package edu.neu.cs5200.msn.orm.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Movie {
	@Id
	private Integer id;
	private String title;
	private String plot;
	private String poster;
	private String movieId;
	@OneToMany(mappedBy="movie")
	private List<Actor> actors;
	
	//private List<Actor> actors;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	public Movie(Integer id, String title, String plot, String poster,
			String movieId) {
		super();
		this.id = id;
		this.title = title;
		this.plot = plot;
		this.poster = poster;
		this.movieId = movieId;
	}
	public Movie(){
		super(); //why use super()?
	}
}
