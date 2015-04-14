package edu.neu.cs5200.msn.orm.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.neu.cs5200.msn.orm.models.Actor;
import edu.neu.cs5200.msn.orm.models.Movie;

public class MovieDAO {	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("MovieSocialNetwork");
	EntityManager em=factory.createEntityManager();	
	//crud
	//createMovie
	private Movie createMovie(Movie movie) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(movie);  
		em.getTransaction().commit();
		return movie;
	}
	//readMovieById
	private Movie readMovieById(Integer id){
		return em.find(Movie.class, id); //如果不用ID 也行，为啥
	}
	//readAllMovies
	private List<Movie> readALLMovies()
	{
		Query query=em.createQuery("select movie from Movie movie");
		return(List<Movie>)query.getResultList();
	}
	
	//updateMovie
	private Movie updateMovie(Movie movie)
	{
		em.getTransaction().begin();
		em.merge(movie);
		em.getTransaction().commit();
		return movie;
	}
	//deleteMovie
	private void deleteMovie(int id) {
		em.getTransaction().begin();
		Movie movie= em.find(Movie.class,id);
		em.remove(movie);
		em.getTransaction().commit();
	}
	private void addActor(Integer movieId,Actor actor)
	{   
		em.getTransaction().begin();
		Movie movie= em.find(Movie.class, movieId);
		actor.setMovie(movie);
		movie.getActors().add(actor);
		em.merge(movie);
		em.getTransaction().commit();
		
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MovieDAO dao= new MovieDAO();
		//Movie movie=new Movie(null,"titanic","plot","psoter","MovieId");
		//movie=dao.createMovie(movie);
		//System.out.println(movie.getId());
		//Movie titanic=dao.readMovieById(3);//why here can't use movie?
		//System.out.println(titanic.getTitle());
		//dao.deleteMovie(1);
		List<Movie> movies= dao.readALLMovies();
		for(Movie movie:movies)
		{
			System.out.println(movie.getTitle());
		}
		//titanic.setPlot("Titanic sinks at the end");
		//dao.updateMovie(titanic);
		Movie aliens=dao.readMovieById(4);
		System.out.println(aliens.getActors().size());
		
		List<Actor> actors=aliens.getActors();
		for(Actor actor:actors)
		{
			System.out.println(actor.getFirst());
		}
		
	}
}
