package br.com.wtw.cfgdemelo.whattowatch

import android.net.Uri
import info.movito.themoviedbapi.TmdbApi
import info.movito.themoviedbapi.TmdbMovies
import info.movito.themoviedbapi.model.MovieDb
import org.jetbrains.anko.doAsync

class ApiAccess(private val main: MainActivity) {

    fun getMovieInfo(movieId: Int) {
        var movies: TmdbMovies?
        var title: String?
        var time: Int?
        var imgPath = "https://image.tmdb.org/t/p/original"
        var moviesMap: MovieDb?
        doAsync {
            val apiKey = "7f2323ddb4283932ca4972d14200c4f2"
            movies = TmdbApi(apiKey).movies
            moviesMap = movies?.getMovie(movieId, "en")
            title = moviesMap?.title
            time = moviesMap?.runtime
            imgPath += moviesMap?.posterPath
            main.setMovieTitle(title)
            main.setMovieTime(time)
            main.runOnUiThread {
                main.setMovieImg(Uri.parse(imgPath))
            }
        }

    }
}
