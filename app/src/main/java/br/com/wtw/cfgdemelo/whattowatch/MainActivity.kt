package br.com.wtw.cfgdemelo.whattowatch

import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.imageURI

class MainActivity : AppCompatActivity() {

    private var imgMovie: ImageView? = null
    private var titleMovie: TextView? = null
    private var timeMovie: TextView? = null
    private var inputMovie: TextInputEditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        imgMovie = findViewById(R.id.imgMovie)
        titleMovie = findViewById(R.id.titleMovie)
        timeMovie = findViewById(R.id.timeMovie)
        inputMovie = findViewById(R.id.inputMovie)

        val api = ApiAccess(this)

        fab.setOnClickListener {
            val inputedMovie = inputMovie?.text
            api.getMovieInfo(Integer.parseInt(inputedMovie.toString()))
        }
    }

    fun setMovieTitle(movieTitle: String?) {
        titleMovie?.text = movieTitle
    }

    fun setMovieTime(movieTime: Int?) {
        timeMovie?.text = movieTime?.swap()
    }

    fun setMovieImg(movieImg: Uri) {
        Picasso.get().load(movieImg).into(imgMovie)
    }

    private fun Int.swap() : String {
        val hoursInt = this / 60
        val minutesLeft = this % 60
        val hoursMeter = if (hoursInt > 1) getText(R.string.hours) else getText(R.string.hour)
        val minutesMeter = if (minutesLeft > 1) getText(R.string.minutes) else getText(R.string.minute)
        val and = getText(R.string.and)
        val noHours = "$minutesLeft $minutesMeter"
        val hoursAndMinutes = "$hoursInt $hoursMeter $and $minutesLeft $minutesMeter"
        val noMinutes = "$hoursInt $hoursMeter"
        val time: String

        if (hoursInt > 0 && minutesLeft > 0) {
            time = hoursAndMinutes
        } else if (minutesLeft > 0) {
            time = noHours
        } else {
            time = noMinutes
        }

        return time
    }
}
