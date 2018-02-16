module Bob (responseFor) where
import Data.Char (toUpper, isLetter)
import Data.List (isSuffixOf)

responseFor :: String -> String
responseFor statement
    | isSilence = "Fine. Be that way!"
    | isForcefulQuestion = "Calm down, I know what I'm doing!"
    | isQuestion = "Sure."
    | isShouting = "Whoa, chill out!"
    | otherwise = "Whatever."
    where
    isSilence = statement == ""
    isForcefulQuestion = isQuestion && isShouting
    isShouting = any isLetter statement && statement == map toUpper statement
    isQuestion = "?" `isSuffixOf` statement
