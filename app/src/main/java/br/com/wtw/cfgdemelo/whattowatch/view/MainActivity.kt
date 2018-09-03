package br.com.wtw.cfgdemelo.whattowatch.view

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.wtw.cfgdemelo.whattowatch.api.ApiAccess
import br.com.wtw.cfgdemelo.whattowatch.extensions.numbers.swap
import br.com.wtw.cfgdemelo.whattowatch.R
import br.com.wtw.cfgdemelo.whattowatch.viewModel.MainViewModel
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val viewModel = MainViewModel(this)

        fab.setOnClickListener {
            viewModel.getMovieInfo()
        }
    }

    fun setMovieTitle(movieTitle: String?) {
        titleMovie?.text = movieTitle
    }

    fun setMovieTime(movieTime: Int?) {
        timeMovie?.text = movieTime?.swap(this)
    }

    fun setMovieImg(movieImg: Uri) {
        Picasso.get().load(movieImg).into(imgMovie)
    }
}
