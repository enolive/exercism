type OldStructure = { [key: string]: string[] }
type NewStructure = { [p: string]: number }

class OldEntry {
    private readonly key: number

    constructor(key: string, private values: string[]) {
        this.key = +key
    }

    forEachValue(callback: (key: number, value: string) => void) {
        this.values
            .map((value) => value.toLowerCase())
            .forEach((value) => callback(this.key, value))
    }
}

export default (old: OldStructure) => {
    const result: NewStructure = {}
    Object.entries(old)
        .map(([key, values]) => new OldEntry(key, values))
        .forEach((entry) => entry.forEachValue((key, value) => result[value] = key))
    return result
}
