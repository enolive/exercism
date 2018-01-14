export default class Series {
    readonly digits: number[]

    constructor(digits: string) {
        this.digits = digits
            .split('')
            .map((d) => parseInt(d, 10))
    }


    slices(length: number) {
        return this.digits
            .map((_, index) => this.digits.slice(index, index + length))
            .filter((slice) => slice.length === length)
    }
}