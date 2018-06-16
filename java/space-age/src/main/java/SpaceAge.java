class SpaceAge {

    private final double seconds;

    SpaceAge(double seconds) {
        this.seconds = seconds;
    }

    double getSeconds() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double onEarth() {
        return Planet.EARTH.toYears(seconds);
    }

    double onMercury() {
        return Planet.MERCURY.toYears(seconds);
    }

    double onVenus() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double onMars() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double onJupiter() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double onSaturn() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double onUranus() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    double onNeptune() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    private enum Planet {
        EARTH(365.25 * 24 * 60 * 60),
        MERCURY(EARTH.yearInSeconds * 0.2408467)
        ;

        private double yearInSeconds;

        Planet(double yearInSeconds) {
            this.yearInSeconds = yearInSeconds;
        }

        double toYears(double seconds) {
            return seconds / yearInSeconds;
        }
    }

}
