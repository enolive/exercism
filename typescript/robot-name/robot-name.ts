import * as _ from "lodash"

export default class RobotName {
    private existingNames = new Set()

    constructor() {
        this.resetName()
    }

    private _name: string

    public get name(): string {
        return this._name
    }

    resetName() {
        this._name = _.times(2, () => this.randomCharacter()).join("") +
            _.times(3, () => this.randomNumberUpTo(10)).join("")
        if (this.existingNames.has(this._name)) {
            this.resetName()
        }

        this.existingNames.add(this.name)
    }

    private randomNumberUpTo(x: number) {
        return Math.floor(Math.random() * x)
    }

    private randomCharacter() {
        return String.fromCharCode(this.randomNumberUpTo(27) + "A".charCodeAt(0))
    }
}