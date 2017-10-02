export default class GradeSchool {
    private map = new Map<string, string[]>()

    studentRoster() {
        return new Map([...this.map.entries()].sort())
    }

    addStudent(name: string, grade: number) {
        const entry = this.entry(grade)
        entry.push(name)
        entry.sort()
        this.map.set(this.key(grade), entry)
    }

    studentsInGrade(grade: number) {
        return this.entry(grade)
    }

    private entry(grade: number) {
        return this.map.get(this.key(grade)) || []
    }

    private key(grade: number) {
        return grade.toString()
    }
}