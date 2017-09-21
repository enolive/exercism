export default class Pangram {
    constructor(private readonly s: string) {
    }

    isPangram() {
        if (this.s.length > 0) {
            return true
        }
        return false
    }
}