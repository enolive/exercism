export default class Gigasecond {
    private start: Date

    constructor(start: Date) {
        this.start = start
    }

    date() {
        const billionSeconds = Math.pow(10, 9)
        const currentMilliseconds = this.start.getTime()
        return new Date(currentMilliseconds + billionSeconds * 1000)
    }
}