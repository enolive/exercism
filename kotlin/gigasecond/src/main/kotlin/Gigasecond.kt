import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit.*
import java.time.temporal.Temporal

class Gigasecond(birth: Temporal) {
    private val amount = Duration.of(1_000_000_000, SECONDS)

    val date: LocalDateTime = when(birth) {
        is LocalDate -> birth.atStartOfDay().plus(amount)
        is LocalDateTime -> birth.plus(amount)
        else -> throw IllegalArgumentException()
    }    
}