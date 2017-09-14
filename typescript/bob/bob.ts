export default class Bob {

    hey(statement: string) {
        if (statement.endsWith("?")) {
            return "Sure."
        }
        if (statement.endsWith("!")) {
            return "Whoa, chill out!"
        }
        return "Whatever."
    }
}