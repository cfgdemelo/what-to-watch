package br.com.wtw.cfgdemelo.whattowatch.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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

        val viewModel = MainViewModel()

        fab.setOnClickListener {
            viewModel.getMovieInfo(Integer.parseInt(inputMovie.text.toString()))
        }

        viewModel.observable.subscribe {
            titleMovie?.text = it.movieTitle
            runOnUiThread {
                Picasso.get().load(it.posterPath).into(imgMovie)
            }
            timeMovie?.text = it.movieTime?.swap(this)
        }
    }
}
