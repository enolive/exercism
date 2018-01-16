interface OldStructure {
    [p: string]: string[]
}

interface NewStructure {
    [p: string]: number
}

class NewStructureBuilder {
    private result: NewStructure = {}

    build(): NewStructure {
        return this.result
    }

    add(entry: OldEntry) {
        entry.forEachValue(this.addToResult())
        return this
    }

    private addToResult() {
        return (key: number, value: string) => this.result[value] = key
    }
}

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

export default (old: OldStructure) =>
    Object.entries(old)
        .map(([key, values]) => new OldEntry(key, values))
        .reduce((acc: NewStructureBuilder, entry) => acc.add(entry), new NewStructureBuilder())
        .build()
