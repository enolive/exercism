export default class Bob {

    private saysNothing = (statement: string) =>
        this.compose(this.isEmpty)(this.trimmed)(statement)
    private isShouting = (statement: string) =>
        this.containsSomeLetters(statement) ? this.upperCased(statement) === statement : false
    private everythingElse = (_: string) => true
    private isQuestion = (statement: string) => statement.endsWith("?")
    private isEmpty = (statement: string) => statement === ""
    private trimmed = (statement: string) => statement.trim()
    private containsSomeLetters = (statement: string) =>
        this.compose(this.matches)(this.upperCased)(statement)(/[A-ZÄÖÜ]/)
    private upperCased = (statement: string) => statement.toUpperCase()
    private matches = (statement: string) => (regexp: RegExp) => statement.match(regexp)

    private compose = f => g => x => f(g(x))

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