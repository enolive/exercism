export default class Anagram {
    private word: string
    private lettersFromWord: string[]

    constructor(word: string) {
        this.word = word.toLowerCase()
        this.lettersFromWord = Anagram.orderedLettersFrom(this.word)
    }

    matches(...candidates: string[]) {
        return candidates.filter((candidate) => this.hasSameLetters(candidate))
    }

    private static orderedLettersFrom(word: string) {
        return word.split('').sort()
    }

    private static zip(a: string[], b: string[]) {
        return a.map((value, index) => [value, b[index]])
    }

    private hasSameLetters(other: string) {
        const candidate = other.toLowerCase()
        if (this.word === candidate) {
            return false
        }
        if (candidate.length !== this.word.length) {
            return false
        }
        return Anagram
            .zip(this.lettersFromWord,
                Anagram.orderedLettersFrom(candidate))
            .every(([c, w]) => c === w)
    }
}