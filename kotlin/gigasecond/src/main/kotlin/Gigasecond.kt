import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit.*

class Gigasecond(birth: LocalDateTime) {
    private val amount = Math.pow(10.0, 9.0).toLong()

    val date: LocalDateTime = birth.plus(amount, SECONDS)

    constructor(birth: LocalDate) : this(birth.atStartOfDay())

}