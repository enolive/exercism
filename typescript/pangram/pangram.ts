export default class Pangram {
    private alphabet = new Set<string>('abcdefghijklmnopqrstuvwxyz'.split(''))

    constructor(private readonly sentence: string) {
    }

    isPangram() {
        const set = new Set<string>(this.sentence.split('').filter(c => this.isLetter(c)))
        return set.size === this.alphabet.size
    }

    private isLetter(character: string) {
        return this.alphabet.has(character)
    }
}
