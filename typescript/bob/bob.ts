import "./extensions"

export default class Bob {
    private saysNothing = (statement: string) =>
        statement.trim().isEmpty()
    private isShouting = (statement: string) =>
        this.containsSomeLetters(statement) ? statement.toUpperCase() === statement : false
    private everythingElse = (_: string) => true
    private isQuestion = (statement: string) => statement.endsWith("?")
    private containsSomeLetters = (statement: string) =>
        statement.toUpperCase().match(/[A-ZÄÖÜ]/)

    hey(statement: string) {

        const rules = [
            {appliesTo: this.saysNothing, result: "Fine. Be that way!"},
            {appliesTo: this.isShouting, result: "Whoa, chill out!"},
            {appliesTo: this.isQuestion, result: "Sure."},
            {appliesTo: this.everythingElse, result: "Whatever."},
        ]

        const [match] = rules
            .filter(r => r.appliesTo(statement))
            .map(r => r.result)
        return match
    }
}