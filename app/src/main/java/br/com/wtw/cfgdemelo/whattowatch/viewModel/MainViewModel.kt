package br.com.wtw.cfgdemelo.whattowatch.viewModel

import android.net.Uri
import br.com.wtw.cfgdemelo.whattowatch.api.ApiAccess
import br.com.wtw.cfgdemelo.whattowatch.view.MainActivity
import info.movito.themoviedbapi.model.MovieDb
import io.reactivex.Observable
import org.jetbrains.anko.doAsync

class MainViewModel(private val main: MainActivity) {

    fun getMovieInfo() {
        var imgPath = "https://image.tmdb.org/t/p/original"
        doAsync {
            val movieDb: MovieDb? = ApiAccess().getMovieInfo(186734)
            Observable.just(movieDb).subscribe {
                imgPath += it?.posterPath
                main.setMovieTitle(it?.title)
                main.setMovieTime(it?.runtime)
                main.runOnUiThread {
                    main.setMovieImg(Uri.parse(imgPath))
                }
            }
        }
    }
}