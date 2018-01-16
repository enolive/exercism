interface OldStructure {
    [p: string]: string[]
}
interface NewStructure {
    [p: string]: number
}

const transform = (old: OldStructure) => {
    const result: NewStructure = {}
    const keys = Object.keys(old)
    keys.forEach(processKey(old, fill(result)))
    return result
}

export default transform

const processKey = (old: OldStructure, fillWith: (key: string) => (value: string) => void) => (key: string) => {
    const values = old[key]
    values
        .map(transformValue)
        .forEach(fillWith(key))
}

const transformValue = (value: string) => value.toLowerCase()

const fill = (result: NewStructure) => (key: string) => (value: string) => {
    result[value] = +key
}
