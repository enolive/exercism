export default class Pangram {
    private alphabet = new Set<string>('abcdefghijklmnopqrstuvwxyz'.split(''))

    constructor(private readonly sentence: string) {
    }

    isPangram() {
        const presentCharacters = new Set<string>(this.sentence
            .toLowerCase()
            .split('')
            .filter(c => this.isLetter(c)))
        return presentCharacters.size === this.alphabet.size
    }

    private isLetter(character: string) {
        return this.alphabet.has(character)
    }
}
