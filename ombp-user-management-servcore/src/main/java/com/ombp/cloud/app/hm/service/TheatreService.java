package com.ombp.cloud.app.hm.service;

import java.util.List;

import com.ombp.cloud.model.bs.Movie;
import com.ombp.cloud.model.bs.MovieShow;
import com.ombp.cloud.model.bs.Screen;
import com.ombp.cloud.model.bs.SearchCriteria;
import com.ombp.cloud.model.bs.Theatre;

public interface TheatreService {

	MovieShow saveMovieShow(MovieShow movieShow);

	Movie fetchMovieByMovieName(String movieName);

	List<Screen> fetchAllScreensByTheatreId(Integer theatreId);

	List<MovieShow> fetchAllShowsByTheatreId(Integer theatreId);

	List<Theatre> fetchAllTheatreBySearchCriteria(SearchCriteria searchCriteria);
}
