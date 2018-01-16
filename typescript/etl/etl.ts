type OldStructure = { [key: string]: string[] }
type NewStructure = { [p: string]: number }

export default (old: OldStructure) => {
    const result: NewStructure = {}
    Object.entries(old)
        .forEach(([key, values]) =>
            values.forEach((value) =>
                result[value.toLowerCase()] = +key))
    return result
}
