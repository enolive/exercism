export default class Bob {

    hey(statement: string) {
        if (statement.endsWith("?")) {
            return "Sure."
        }
        if (statement.toUpperCase() === statement) {
            return "Whoa, chill out!"
        }
        return "Whatever."
    }
}