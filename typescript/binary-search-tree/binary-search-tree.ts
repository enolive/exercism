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

    each(action: (data: number) => void) {
        if (this._left) {
            this._left.each(action)
        }
        action(this.data)
        if (this._right) {
            this._right.each(action)
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
