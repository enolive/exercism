export default (word: string | undefined) =>
    lettersOf(word)
        .map(scoreForLetter)
        .reduce((sum, score) => sum + score, 0)

const lettersOf = (word: string | undefined) =>
    (word || '')
        .toLowerCase()
        .split('')
        .filter((letter) => letter.match(/\w/))

const scoreForLetter = (letter: string) => {
    const [score] = scoringRules
        .filter((rule) => rule.appliesTo(letter))
        .map((rule) => rule.score)
    return score
}

const letters = (...applyingLetters: string[]) =>
    (letter: string) => applyingLetters.some((w) => w === letter)

const scoringRules = [
    {score: 1, appliesTo: letters('a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't')},
    {score: 2, appliesTo: letters('d', 'g')},
    {score: 3, appliesTo: letters('b', 'c', 'm', 'p')},
    {score: 4, appliesTo: letters('f', 'h', 'v', 'w', 'y')},
    {score: 5, appliesTo: letters('k')},
    {score: 8, appliesTo: letters('j', 'x')},
    {score: 10, appliesTo: letters('q', 'z')},
]
