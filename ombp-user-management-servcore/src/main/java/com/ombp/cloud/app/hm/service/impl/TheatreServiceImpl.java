package com.ombp.cloud.app.hm.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ombp.cloud.app.hm.dao.TheatreDao;
import com.ombp.cloud.app.hm.service.TheatreService;
import com.ombp.cloud.model.bs.Movie;
import com.ombp.cloud.model.bs.MovieShow;
import com.ombp.cloud.model.bs.Screen;
import com.ombp.cloud.model.bs.SearchCriteria;
import com.ombp.cloud.model.bs.Theatre;

@Service
public class TheatreServiceImpl implements TheatreService {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TheatreDao theatreDao;
	
	@Override
	public MovieShow saveMovieShow(MovieShow movieShow) {
		if(movieShow.getId()==null) 
		{
			theatreDao.insertMovieShow(movieShow);
		}
		else 
		{
			theatreDao.updateMovieShow(movieShow);
		}
		return movieShow;
	}

	@Override
	public Movie fetchMovieByMovieName(String movieName) {
		return theatreDao.fetchMovieByMovieName(movieName);
	}

	@Override
	public List<Screen> fetchAllScreensByTheatreId(Integer theatreId) {
		return theatreDao.fetchAllScreensByTheatreId(theatreId);
	}

	@Override
	public List<MovieShow> fetchAllShowsByTheatreId(Integer theatreId) {
		return theatreDao.fetchAllShowsByTheatreId(theatreId);
	}

	@Override
	public List<Theatre> fetchAllTheatreBySearchCriteria(SearchCriteria searchCriteria) {
		return theatreDao.fetchAllTheatreBySearchCriteria(searchCriteria);
	}

}
