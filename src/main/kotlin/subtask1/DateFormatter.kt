package subtask1

import java.time.DateTimeException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.*

class DateFormatter {

    fun main(){
        toTextDay("12","2","2021")
    }
    // TODO: Complete the following function
    fun toTextDay(day: String, month: String, year: String): String {
        var dateString = ""
        val ru = Locale("ru")

        try {
            val localDate  = LocalDate.of(year.toInt(), month.toInt() , day.toInt())
            val monthString = localDate.format(DateTimeFormatter.ofPattern("MMMM", ru))
            val dayOfWeek   = localDate.dayOfWeek.getDisplayName(TextStyle.FULL_STANDALONE, ru)

            dateString = "$day $monthString, $dayOfWeek"
        }catch (exc: DateTimeException){

            dateString = "Такого дня не существует"
        }
        return dateString
    }
}
