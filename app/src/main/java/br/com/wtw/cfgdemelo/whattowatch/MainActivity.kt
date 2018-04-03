package br.com.wtw.cfgdemelo.whattowatch

import android.content.res.Resources
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import info.movito.themoviedbapi.model.MovieDb

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var imgMovie: ImageView? = null
    private var titleMovie: TextView? = null
    private var timeMovie: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        imgMovie = findViewById(R.id.imgMovie)
        titleMovie = findViewById(R.id.titleMovie)
        timeMovie = findViewById(R.id.timeMovie)
        val api = ApiAccess(this)

        fab.setOnClickListener {
            api.getMovieTitle()
            api.getMovieTime()
        }
    }

    fun setMovieTitle(movieTitle: String?) {
        titleMovie?.text = movieTitle
    }

    fun setMovieTime(movieTime: Int?) {
        timeMovie?.text = movieTime?.swap()
    }

    private fun Int.swap() : String {
        val hoursInt = this / 60
        val minutesLeft = this % 60
        val hoursMeter = if (hoursInt > 1) getText(R.string.hours) else getText(R.string.hour)
        val minutesMeter = if (minutesLeft > 1) getText(R.string.minutes) else getText(R.string.minute)
        val and = getText(R.string.and)
        val noHours = "$minutesLeft $minutesMeter"
        val withHours = "$hoursInt $hoursMeter $and $minutesLeft $minutesMeter"
        var time: String
        if (hoursInt > 0) time = withHours else time = noHours
        return time
    }
}
