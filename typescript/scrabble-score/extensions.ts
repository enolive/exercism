// noinspection JSUnusedGlobalSymbols - required for proper type extending in TS
declare interface Array<T> {
    head(): T
}

Array.prototype.head = function<T>(): T {
    /* tslint:disable:no-invalid-this */
    if (this.length === 0) {
        throw new RangeError('array is empty')
    }
    return this[0]
    /* tslint:enable:no-invalid-this */
}
