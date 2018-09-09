package br.com.wtw.cfgdemelo.whattowatch.repository

import info.movito.themoviedbapi.model.MovieDb

class MovieInfo (movieDb: MovieDb?) {

    private val originalPosterPath = movieDb?.posterPath
    val posterPath = "https://image.tmdb.org/t/p/original$originalPosterPath"
    val movieTime = movieDb?.runtime
    val movieTitle = movieDb?.title
}