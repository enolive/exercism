import {StudentsRoster} from "./students-roster"

export default class GradeSchool {
    private roster = new StudentsRoster()

    studentRoster() {
        return this.roster.toMap()
    }

    addStudent(name: string, grade: number) {
        this.roster.addStudent(name, grade)
    }

    studentsInGrade(grade: number) {
        return this.roster.findAllStudentsIn(grade)
    }
}