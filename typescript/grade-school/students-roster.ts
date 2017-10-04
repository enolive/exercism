export class StudentsRoster {
    private map = new Map<string, string[]>()

    private static copyEntries(entries: IterableIterator<[string, string[]]>) {
        return [...entries]
            .map((entry) => StudentsRoster.copyEntry(entry))
            .sort() as Array<[string, string[]]>
    }

    private static copyNames(originalNames: string[]) {
        return [...originalNames]
    }

    private static copyEntry(entry: [string, string[]]) {
        const [key, names] = entry
        return [key, StudentsRoster.copyNames(names)]
    }

    private static key(grade: number) {
        return grade.toString()
    }

    toMap() {
        return new Map(StudentsRoster.copyEntries(this.map.entries()))
    }

    addStudent(name: string, grade: number) {
        const entry = this.names(grade)
        entry.push(name)
        entry.sort()
        this.map.set(StudentsRoster.key(grade), entry)
    }

    findAllStudentsIn(grade: number) {
        return StudentsRoster.copyNames(this.names(grade))
    }

    private names(grade: number) {
        return this.map.get(StudentsRoster.key(grade)) || []
    }
}