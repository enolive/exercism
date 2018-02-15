module Bob (responseFor) where
import Data.Char (toUpper)

responseFor :: String -> String
responseFor statement
    | statement == map toUpper statement = "Whoa, chill out!"
    | otherwise = "Whatever."
