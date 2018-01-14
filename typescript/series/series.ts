export default class Series {
    readonly digits: number[]

    constructor(digits: string) {
        this.digits = digits
            .split('')
            .map((d) => parseInt(d, 10))
    }

    slices(length: number) {
        this.throwIfInvalid(length)
        return this.digits
            .map((_, index) => this.slice(index, length))
            .filter((slice) => slice.length > 0)
    }

    private throwIfInvalid(length: number) {
        if (length > this.digits.length) {
            throw new IllegalArgumentError(
                `the specified length ${length} is greater than the number of digits ${this.digits.length}`)
        }
    }

    private slice(index: number, length: number) {
        const end = index + length
        return this.digits.length < end
            ? []
            : this.digits.slice(index, end)
    }
}

export class IllegalArgumentError extends Error {
}