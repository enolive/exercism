export default function transform(old: { [p: string]: string[] }) {
    const keys = Object.keys(old)
    const key = keys[0]
    const values = old[key]
    const value = values[0].toLowerCase()
    const result: {[key: string]: number} = {}
    result[value] = +key
    return result
}
