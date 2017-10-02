import SpaceAge from "./space-age"

describe("Space Age", () => {

    it("age in seconds", () => {
        const age = new SpaceAge(1000000)
        expect(age.seconds).toEqual(1000000)
    })

    it("age in earth years", () => {
        const age = new SpaceAge(1000000000)
        expect(age.onEarth()).toEqual(31.69)
    })

    it("age in mercury years", () => {
        const age = new SpaceAge(2134835688)
        expect(age.onEarth()).toEqual(67.65)
        expect(age.onMercury()).toEqual(280.9)
    })

    it("age in venus years", () => {
        const age = new SpaceAge(189839836)
        expect(age.onEarth()).toEqual(6.02)
        expect(age.onVenus()).toEqual(9.78)
    })

    it("age in mars years", () => {
        const age = new SpaceAge(2329871239)
        expect(age.onEarth()).toEqual(73.83)
        expect(age.onMars()).toEqual(39.26)
    })

    it("age in jupiter years", () => {
        const age = new SpaceAge(901876382)
        expect(age.onEarth()).toEqual(28.58)
        expect(age.onJupiter()).toEqual(2.41)
    })

    it("age in saturn years", () => {
        const age = new SpaceAge(3000000000)
        expect(age.onEarth()).toEqual(95.07)
        expect(age.onSaturn()).toEqual(3.23)
    })

    it("age in uranus years", () => {
        const age = new SpaceAge(3210123456)
        expect(age.onEarth()).toEqual(101.73)
        expect(age.onUranus()).toEqual(1.21)
    })

    it("age in neptune year", () => {
        const age = new SpaceAge(8210123456)
        expect(age.onEarth()).toEqual(260.18)
        expect(age.onNeptune()).toEqual(1.58)
    })
})