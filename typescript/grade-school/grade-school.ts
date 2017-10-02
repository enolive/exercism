export default class GradeSchool {
    private _map = new Map<string, string[]>()

    studentRoster() {
        return this._map
    }

    addStudent(name: string, grade: number) {
        this._map.set(grade.toString(), [name])
    }
}