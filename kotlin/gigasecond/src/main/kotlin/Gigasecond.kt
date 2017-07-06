import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit.*

class Gigasecond(birth: LocalDateTime) {
    private val amount = Duration.of(1_000_000_000, SECONDS)

    val date: LocalDateTime = birth.plus(amount)

    constructor(birth: LocalDate) : this(birth.atStartOfDay())

}