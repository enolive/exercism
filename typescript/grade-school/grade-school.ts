export default class GradeSchool {
    private map = new Map<string, string[]>()

    studentRoster() {
        return this.map
    }

    addStudent(name: string, grade: number) {
        const key = grade.toString()
        const entry = this.map.get(key) || []
        entry.push(name)
        this.map.set(key, entry)
    }
}