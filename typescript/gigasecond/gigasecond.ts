export default class Gigasecond {
    private start: Date

    constructor(start: Date) {
        this.start = start
    }

    date() {
        const currentMilliseconds = this.start.getTime()
        const billionSeconds = 10 ** 9
        return new Date(currentMilliseconds + billionSeconds * 1000)
    }
}