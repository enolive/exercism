export default class Words {
    count(sentence: string) {
        return sentence
            .toLowerCase()
            .split(/\s+/)
            .filter(Words.notEmpty)
            .reduce(Words.countOccurrences, Words.emptyMap())
    }

    private static emptyMap(): Map<string, number> {
        return new Map<string, number>()
    }

    private static notEmpty(word: string): boolean {
        return word.length > 0
    }

    private static countOccurrences(acc: Map<string, number>, word: string) {
        const count = acc.get(word) || 0
        acc.set(word, count + 1)
        return acc
    }
}