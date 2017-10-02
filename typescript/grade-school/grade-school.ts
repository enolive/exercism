export default class GradeSchool {
    private map = new Map<string, string[]>()

    studentRoster() {
        return this.map
    }

    addStudent(name: string, grade: number) {
        const entry = this.entry(grade)
        entry.push(name)
        this.map.set(this.key(grade), entry)
    }

    studentsInGrade(grade: number) {
        const entry = this.entry(grade)
        entry.sort()
        return entry
    }

    private entry(grade: number) {
        return this.map.get(this.key(grade)) || []
    }

    private key(grade: number) {
        return grade.toString()
    }
}