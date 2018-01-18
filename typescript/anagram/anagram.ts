export default class Anagram {
    constructor(private word: string) {
    }

    matches(...candidates: string[]) {
        return candidates.filter((candidate) => this.hasSameLetters(candidate))
    }

    private hasSameLetters(candidate: string) {
        return candidate.length === this.word.length;
    }
}