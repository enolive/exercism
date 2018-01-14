export default class BinarySearchTree {
    constructor(data: number) {
        this._data = data
    }

    private _right: BinarySearchTree

    get right(): BinarySearchTree {
        return this._right
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
        if (data > this.data) {
            this._right = this.insertOrCreate(data, this._right)
        }
        else {
            this._left = this.insertOrCreate(data, this._left)
        }
    }

    private insertOrCreate(data: number, node: BinarySearchTree) {
        if (!node) {
            return new BinarySearchTree(data)
        }
        node.insert(data)
        return node
    }
}
