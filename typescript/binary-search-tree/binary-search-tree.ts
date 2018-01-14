export default class BinarySearchTree {
    constructor(data: number) {
        this._data = data
    }
    
    private _data: number

    get data(): number {
        return this._data
    }
}
