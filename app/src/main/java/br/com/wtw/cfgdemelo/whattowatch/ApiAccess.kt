package br.com.wtw.cfgdemelo.whattowatch

import android.content.res.Resources
import android.os.AsyncTask
import info.movito.themoviedbapi.TmdbApi
import info.movito.themoviedbapi.TmdbMovies
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult

class ApiAccess(private val main: MainActivity) {

    fun getMovieTitle() {
        var movies: TmdbMovies? = null
        var title: String? = null
        doAsync {
            val apiKey = "7f2323ddb4283932ca4972d14200c4f2"
            movies = TmdbApi(apiKey).movies
            title = movies?.getMovie(186734, "en")?.title
            main.setMovieTitle(title)
        }
    }

    fun getMovieTime() {
        var movies: TmdbMovies?
        var time: Int?
        doAsync {
            val apiKey = "7f2323ddb4283932ca4972d14200c4f2"
            movies = TmdbApi(apiKey).movies
            time = movies?.getMovie(186734, "en")?.runtime
            main.setMovieTime(time)
        }
    }
}
