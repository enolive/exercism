module Bob (responseFor) where
import Data.Char (toUpper)
import Data.List (isInfixOf)

responseFor :: String -> String
responseFor statement
    | isForcefulQuestion = "Calm down, I know what I'm doing!"
    | isQuestion = "Sure."
    | isShouting = "Whoa, chill out!"
    | otherwise = "Whatever."
    where
    isForcefulQuestion = isQuestion && isShouting
    isShouting = statement == map toUpper statement
    isQuestion = "?" `isInfixOf` statement
