import _ = require('lodash')

export default class Pangram {
    private alphabet = new Set<string>(this.characterRange('a', 'z'))

    constructor(private readonly sentence: string) {
    }

    isPangram() {
        const presentCharacters = new Set<string>(this.sentence
            .toLowerCase()
            .split('')
            .filter(c => this.isLetter(c)))
        return presentCharacters.size === this.alphabet.size
    }

    private characterRange(from: string, to: string) {
        return _.range(from.charCodeAt(0), to.charCodeAt(0), 1)
            .map(c => String.fromCharCode(c))
    }

    private isLetter(character: string) {
        return this.alphabet.has(character)
    }
}
