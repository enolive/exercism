export default function transform(old: { [p: string]: string[] }) {
    const result: {[key: string]: number} = {}
    const keys = Object.keys(old)
    const key = keys[0]
    processKey(old, key, result)
    return result
}
const processKey = (old: { [p: string]: string[] }, key: string, result: { [p: string]: number }) => {
    const values = old[key]
    const value = values[0].toLowerCase()
    fill(result, value, key)
}
const fill = (result: { [p: string]: number }, value: string, key: string) => {
    result[value] = +key
}
