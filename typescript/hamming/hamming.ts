export default class Hamming {

    compute(first: string, second: string) {
        return Hamming.zip(first, second)
            .filter(([f, s]) => f !== s)
            .length
    }

    private static throwOnLengthMismatch(first: string, second: string) {
        if (first.length !== second.length) {
            throw "DNA strands must be of equal length."
        }
    }

    private static zip(first: string, second: string) {
        Hamming.throwOnLengthMismatch(first, second)
        return first.split("")
            .map((c, index) => [c, second[index]])
    }
}