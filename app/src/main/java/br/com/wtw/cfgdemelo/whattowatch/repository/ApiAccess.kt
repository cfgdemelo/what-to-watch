package br.com.wtw.cfgdemelo.whattowatch.repository

import info.movito.themoviedbapi.TmdbApi
import info.movito.themoviedbapi.TmdbMovies
import info.movito.themoviedbapi.model.MovieDb

class ApiAccess {

    fun getMovieInfo(movieId: Int) : MovieInfo? {
        val movies: TmdbMovies?
        val moviesMap: MovieDb?
        val apiKey = "7f2323ddb4283932ca4972d14200c4f2"
        movies = TmdbApi(apiKey).movies
        moviesMap = movies?.getMovie(movieId, "en")
        return MovieInfo(moviesMap)
    }
}
