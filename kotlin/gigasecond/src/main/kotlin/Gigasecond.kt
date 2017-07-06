import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit.*

class Gigasecond(startTime: LocalDateTime) {
    private val amount = Math.pow(10.0, 9.0).toLong()

    val date: LocalDateTime = startTime.plus(amount, SECONDS)

    constructor(startDate: LocalDate) : this(startDate.atStartOfDay())

}