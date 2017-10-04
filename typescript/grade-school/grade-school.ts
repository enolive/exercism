export default class GradeSchool {
    private map = new Map<string, string[]>()

    private static copyNames(originalNames: string[]) {
        return [...originalNames]
    }

    private static copyEntry(entry: [string, string[]]) {
        const [key, names] = entry
        return [key, GradeSchool.copyNames(names)]
    }

    private static key(grade: number) {
        return grade.toString()
    }

    private static copyEntries(entries: IterableIterator<[string, string[]]>) {
        return [...entries]
            .map((entry) => GradeSchool.copyEntry(entry))
            .sort() as Array<[string, string[]]>
    }

    studentRoster() {
        return new Map(GradeSchool.copyEntries(this.map.entries()))
    }

    addStudent(name: string, grade: number) {
        const entry = this.names(grade)
        entry.push(name)
        entry.sort()
        this.map.set(GradeSchool.key(grade), entry)
    }

    studentsInGrade(grade: number) {
        const originalNames = this.names(grade)
        return GradeSchool.copyNames(originalNames)
    }

    private names(grade: number) {
        return this.map.get(GradeSchool.key(grade)) || []
    }
}