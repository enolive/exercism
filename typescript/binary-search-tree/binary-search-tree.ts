export default class BinarySearchTree {
    constructor(data: number) {
        this._data = data
    }

    private _left: BinarySearchTree

    get left(): BinarySearchTree {
        return this._left
    }

    private _data: number

    get data(): number {
        return this._data
    }

    insert(data: number) {
        this._left = new BinarySearchTree(data)
    }
}
