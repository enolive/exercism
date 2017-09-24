enum YearOnPlanet {
    EARTH = 1.0,
    MERCURY = 0.2408467,
    VENUS = 0.61519726,
    MARS = 1.8808158,
    JUPITER = 11.862615,
    SATURN = 29.447498,
    URANUS = 84.016846,
    NEPTUNE = 164.79132,
    // TODO: add Nibiru
}

export default class SpaceAge {
    onEarth = () => this.on(YearOnPlanet.EARTH)
    onMercury = () => this.on(YearOnPlanet.MERCURY)
    onVenus = () => this.on(YearOnPlanet.VENUS)
    onMars = () => this.on(YearOnPlanet.MARS)
    onJupiter = () => this.on(YearOnPlanet.JUPITER)
    onSaturn = () => this.on(YearOnPlanet.SATURN)
    onUranus = () => this.on(YearOnPlanet.URANUS)
    onNeptune = () => this.on(YearOnPlanet.NEPTUNE)

    private yearOnEarth = (seconds: number) => 3.169E-8 * seconds
    private rounded = (x: number) => +x.toFixed(2)
    private on = (whichPlanet: number) => this.rounded(this.yearOnEarth(this.seconds) / whichPlanet)

    constructor(readonly seconds: number) {
    }
}