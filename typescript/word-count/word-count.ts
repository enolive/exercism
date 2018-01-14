export default class Words {
    count(sentence: string) {
        return sentence
            .toLowerCase()
            .split(/\s+/)
            .filter(Words.notEmpty)
            .reduce(Words.collectToMap, Words.emptyMap())
    }

    private static emptyMap(): Map<string, number> {
        return new Map<string, number>()
    }

    private static notEmpty(word: string): boolean {
        return word.length > 0
    }

    private static collectToMap(acc: Map<string, number>, word: string) {
        const count = acc.has(word) ? acc.get(word)! + 1 : 1
        acc.set(word, count)
        return acc
    }
}