export default class Series {
    readonly digits: number[]

    constructor(digits: string) {
        this.digits = digits
            .split('')
            .map((d) => parseInt(d, 10))
    }


}