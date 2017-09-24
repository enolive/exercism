import * as _ from "lodash"

export default class RobotName {
    private static existingNames = new Set<string>()

    constructor() {
        this.resetName()
    }

    private _name: string

    public get name(): string {
        return this._name
    }

    resetName() {
        do {
            this._name = this.generateName()
        } while (RobotName.existingNames.has(this.name))
        RobotName.existingNames.add(this.name)
    }

    generateName() {
        return _.times(2, () => this.randomCharacter()).join("") +
            _.times(3, () => this.randomNumberUpTo(9)).join("")
    }

    randomNumberUpTo(x: number) {
        return Math.round(Math.random() * x)
    }

    randomCharacter() {
        return String.fromCharCode(this.randomNumberUpTo("Z".charCodeAt(0) - "A".charCodeAt(0)) + "A".charCodeAt(0))
    }
}