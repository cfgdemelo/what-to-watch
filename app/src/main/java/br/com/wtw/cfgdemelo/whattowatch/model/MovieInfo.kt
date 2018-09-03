package br.com.wtw.cfgdemelo.whattowatch.model

import info.movito.themoviedbapi.model.MovieDb

class MovieInfo: MovieDb() {
    override fun getPosterPath(): String {
        val posterPath = super.getPosterPath()
        return "https://image.tmdb.org/t/p/original$posterPath"
    }
}