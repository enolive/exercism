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
            this._right = new BinarySearchTree(data)
        }
        else {
            this._left = new BinarySearchTree(data)
        }
    }
}
