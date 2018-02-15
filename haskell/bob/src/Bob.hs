module Bob (responseFor) where
import Data.Char (toUpper)
import Data.List (isInfixOf)

responseFor :: String -> String
responseFor statement
    | isQuestion && isShouting = "Calm down, I know what I'm doing!"
    | isQuestion = "Sure."
    | isShouting = "Whoa, chill out!"
    | otherwise = "Whatever."
    where
    isShouting = statement == map toUpper statement
    isQuestion = "?" `isInfixOf` statement
