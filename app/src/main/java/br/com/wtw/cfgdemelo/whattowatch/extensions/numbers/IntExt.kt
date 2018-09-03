package br.com.wtw.cfgdemelo.whattowatch.extensions.numbers

import android.content.Context
import br.com.wtw.cfgdemelo.whattowatch.R

fun Int.swap(context: Context) : String {
    val hoursInt = this / 60
    val minutesLeft = this % 60
    val hoursMeter = if (hoursInt > 1) context.getText(R.string.hours) else context.getText(R.string.hour)
    val minutesMeter = if (minutesLeft > 1) context.getText(R.string.minutes) else context.getText(R.string.minute)
    val and = context.getText(R.string.and)
    val noHours = "$minutesLeft $minutesMeter"
    val hoursAndMinutes = "$hoursInt $hoursMeter $and $minutesLeft $minutesMeter"
    val noMinutes = "$hoursInt $hoursMeter"
    val time: String

    time = if (hoursInt > 0 && minutesLeft > 0) {
        hoursAndMinutes
    } else if (minutesLeft > 0) {
        noHours
    } else {
        noMinutes
    }

    return time
}