export default class Words {
    count(sentence: string) {
        return sentence
            .trim()
            .toLowerCase()
            .split(/\s+/)
            .reduce(Words.countOccurrences, Words.emptyMap())
    }

    private static emptyMap(): Map<string, number> {
        return new Map<string, number>()
    }

    private static countOccurrences(acc: Map<string, number>, word: string) {
        const count = acc.get(word) || 0
        return acc.set(word, count + 1)
    }
}