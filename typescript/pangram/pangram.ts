export default class Pangram {
    constructor(private readonly s: string) {
    }

    isPangram() {
        if (this.s.includes('x')) {
            return true
        }
        return false
    }
}