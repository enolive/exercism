import * as _ from "lodash"

export default class RobotName {
    constructor() {
        this.resetName()
    }

    private _name: string

    public get name(): string {
        return this._name
    }

    resetName() {
        this._name = _.times(2, () => this.randomCharacter()).join("") + this.randomNumberUpTo(999)
    }

    private randomNumberUpTo(x: number) {
        return Math.round(Math.random() * x)
    }

    private randomCharacter() {
        return String.fromCharCode(this.randomNumberUpTo(26) + "A".charCodeAt(0))
    }
}