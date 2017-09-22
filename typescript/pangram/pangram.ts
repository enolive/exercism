export default class Pangram {
    constructor(private readonly s: string) {
    }

    isPangram() {
        const alphabet = new Set<string>('abcdefghijklmnopqrstuvwxyz'.split(''))
        const set = new Set<string>(this.s.split('').filter(c => alphabet.has(c)))
        return set.size === alphabet.size
    }
}