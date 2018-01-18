export default class Anagram {
    private lettersFromWord: string[]

    constructor(word: string) {
        this.lettersFromWord = Anagram.orderedLettersFrom(word)
    }

    matches(...candidates: string[]) {
        return candidates.filter((candidate) => this.hasSameLetters(candidate))
    }

    private static orderedLettersFrom(candidate: string) {
        return candidate.split('').sort()
    }

    private static zip(a: string[], b: string[]) {
        return a.map((value, index) => [value, b[index]])
    }

    private hasSameLetters(candidate: string) {
        if (candidate.length !== this.lettersFromWord.length) {
            return false
        }
        return Anagram
            .zip(
                Anagram.orderedLettersFrom(candidate),
                this.lettersFromWord)
            .every(([c, w]) => c === w)
    }
}