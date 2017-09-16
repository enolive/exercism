declare interface String {
    isEmpty(): boolean
}

String.prototype.isEmpty = function () {
    return this === ""
}
