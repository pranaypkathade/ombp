package com.ombp.cloud.app.openendpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ombp.cloud.app.hm.service.TheatreService;
import com.ombp.cloud.constants.EndPointConstants;
import com.ombp.cloud.model.bs.Movie;
import com.ombp.cloud.model.bs.MovieShow;
import com.ombp.cloud.model.bs.Screen;
import com.ombp.cloud.model.bs.SearchCriteria;
import com.ombp.cloud.model.bs.Theatre;

@RestController
public class TheatreEndPoint implements EndPointConstants {
	
	@Autowired
	private TheatreService theatreService;
	
	@RequestMapping(value = "/open/save/movieshow", method = RequestMethod.POST)
	public MovieShow saveMovieShow(@RequestBody MovieShow movieShow) throws Exception {
		theatreService.saveMovieShow(movieShow);
		return movieShow;
	}
	
	@RequestMapping(value = "/open/fetch/moviebyname/{movieName}", method = RequestMethod.GET)
	public Movie fetchMovieByMovieName(@PathVariable("movieName") String movieName) throws Exception {
		Movie m = theatreService.fetchMovieByMovieName(movieName);
		return m;
	}
	
	@RequestMapping(value = "/open/fetch/screens/{theatreId}", method = RequestMethod.GET)
	public List<Screen> fetchAllScreensByTheatreId(@PathVariable("theatreId") Integer theatreId) throws Exception {
		List<Screen> li = theatreService.fetchAllScreensByTheatreId(theatreId);
		return li;
	}
	
	@RequestMapping(value = "/open/fetch/shows/{theatreId}", method = RequestMethod.GET)
	public List<MovieShow> fetchAllShowsByTheatreId(@PathVariable("theatreId") Integer theatreId) throws Exception {
		List<MovieShow> li = theatreService.fetchAllShowsByTheatreId(theatreId);
		return li;
	}
	
	@RequestMapping(value = "/open/search/theatres", method = RequestMethod.POST)
	public List<Theatre> fetchAllTheatreBySearchCriteria(@RequestBody SearchCriteria searchCriteria) throws Exception {
		List<Theatre> li = theatreService.fetchAllTheatreBySearchCriteria(searchCriteria);
		return li;
	}
}