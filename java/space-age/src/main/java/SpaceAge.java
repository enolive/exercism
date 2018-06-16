class SpaceAge {

    private final double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double onEarth() {
        return Planet.EARTH.toYears(seconds);
    }

    double onMercury() {
        return Planet.MERCURY.toYears(seconds);
    }

    double onVenus() {
        return Planet.VENUS.toYears(seconds);
    }

    double onMars() {
        return Planet.MARS.toYears(seconds);
    }

    double onJupiter() {
        return Planet.JUPITER.toYears(seconds);
    }

    double onSaturn() {
        return Planet.SATURN.toYears(seconds);
    }

    double onUranus() {
        return Planet.URANUS.toYears(seconds);
    }

    double onNeptune() {
        return Planet.NEPTUNE.toYears(seconds);
    }

    private enum Planet {
        EARTH(365.25 * 24 * 60 * 60),
        MERCURY(EARTH.yearInSeconds * 0.2408467),
        VENUS(EARTH.yearInSeconds * 0.61519726),
        MARS(EARTH.yearInSeconds * 1.8808158),
        JUPITER(EARTH.yearInSeconds * 11.862615),
        SATURN(EARTH.yearInSeconds * 29.447498),
        URANUS(EARTH.yearInSeconds * 84.016846),
        NEPTUNE(EARTH.yearInSeconds * 164.79132);

        private double yearInSeconds;

        Planet(double yearInSeconds) {
            this.yearInSeconds = yearInSeconds;
        }

        double toYears(double seconds) {
            return seconds / yearInSeconds;
        }
    }

}
