module Bob (responseFor) where
import Data.Char (toUpper)
import Data.List (isInfixOf)

responseFor :: String -> String
responseFor statement
    | "?" `isInfixOf` statement = "Sure."
    | isShouting = "Whoa, chill out!"
    | otherwise = "Whatever."
    where isShouting = statement == map toUpper statement
