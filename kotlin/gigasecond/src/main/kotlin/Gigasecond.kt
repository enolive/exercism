import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month

class Gigasecond(of: LocalDateTime) {
    val date: LocalDateTime = LocalDateTime.of(2043, Month.JANUARY, 1, 1, 46, 40)

    constructor(onlyDate: LocalDate) : this(onlyDate.atStartOfDay())

}