export default class Series {
    constructor(digits: string) {
        this._digits = digits
            .split('')
            .map((d) => +d)
    }

    private _digits: number[]

    get digits(): number[] {
        return [...this._digits]
    }

    slices(length: number) {
        this.throwIfInvalid(length)
        return this._digits
            .map((_, index) => this.slice(index, length))
            .filter((slice) => slice.length > 0)
    }

    private throwIfInvalid(length: number) {
        if (length > this._digits.length) {
            throw new IllegalArgumentError(
                `the specified length ${length} is greater than the number of digits ${this._digits.length}`)
        }
    }

    private slice(index: number, length: number) {
        const end = index + length
        return this._digits.length < end
            ? []
            : this._digits.slice(index, end)
    }
}

export class IllegalArgumentError extends Error {
}