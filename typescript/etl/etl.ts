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
        entry.forEachValue((key, value) => this.addToResult(value, key))
        return this
    }

    private addToResult(value: string, key: number) {
        return this.result[value] = key
    }
}

class OldEntry {
    readonly key: number

    constructor(key: string, private values: string[]) {
        this.key = +key
    }

    forEachValue(callback: (key: number, value: string) => void) {
        this.values.map((value) => value.toLowerCase())
            .forEach((value) => callback(this.key, value))
    }
}

export default (old: OldStructure) => {
    return Object.entries(old)
        .map(([key, values]) => new OldEntry(key, values))
        .reduce((acc: NewStructureBuilder, entry) => acc.add(entry), new NewStructureBuilder())
        .build()
}
