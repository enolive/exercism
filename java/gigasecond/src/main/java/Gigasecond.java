import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private final LocalDateTime birthDateTime;

    Gigasecond(LocalDate birthDate) {
        birthDateTime = birthDate.atStartOfDay();
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.birthDateTime = birthDateTime;
    }

    LocalDateTime getDate() {
        return birthDateTime.plusSeconds(1_000_000_000);
    }

}
