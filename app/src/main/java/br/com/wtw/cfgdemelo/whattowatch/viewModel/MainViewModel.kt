package br.com.wtw.cfgdemelo.whattowatch.viewModel

import br.com.wtw.cfgdemelo.whattowatch.repository.ApiAccess
import br.com.wtw.cfgdemelo.whattowatch.repository.MovieInfo
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import org.jetbrains.anko.doAsync

class MainViewModel {
    private var movieInfo = MovieInfo(null)
        set(value) {
            field = value
            doAsync {
                observable.onNext(value)
            }
        }
    val observable = BehaviorSubject.createDefault(movieInfo)!!

    fun getMovieInfo(id: Int) {
        doAsync {
            val movieDb: MovieInfo? = ApiAccess().getMovieInfo(id)
            Observable.just(movieDb).subscribe {
                movieInfo = it!!
            }.dispose()
        }
    }
}