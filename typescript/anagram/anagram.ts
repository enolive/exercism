export default class Anagram {
    private word: string
    private orderedWord: string

    constructor(word: string) {
        this.word = word.toLowerCase()
        this.orderedWord = Anagram.ordered(this.word)
    }

    matches(...candidates: string[]) {
        return candidates.filter((candidate) => this.hasSameLetters(candidate.toLowerCase()))
    }

    private static ordered(word: string) {
        return word.split('').sort().join('')
    }

    private hasSameLetters(candidate: string) {
        return candidate !== this.word && Anagram.ordered(candidate) === this.orderedWord
    }
}