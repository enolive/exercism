module Bob (responseFor) where
import Data.Char (toUpper, isLetter, isSpace)
import Data.List (isSuffixOf)
import Data.Text (unpack, strip, pack)

responseFor :: String -> String
responseFor statement
    | isSilence = "Fine. Be that way!"
    | isForcefulQuestion = "Calm down, I know what I'm doing!"
    | isQuestion = "Sure."
    | isShouting = "Whoa, chill out!"
    | otherwise = "Whatever."
    where
    trimmed = (unpack . strip . pack) statement
    isSilence = all isSpace trimmed
    isForcefulQuestion = isQuestion && isShouting
    isShouting = any isLetter trimmed && trimmed == map toUpper trimmed
    isQuestion = "?" `isSuffixOf` trimmed
