module Bob (responseFor) where
import Data.Char (isLetter, isSpace, isUpper)
import Data.List (isSuffixOf)

responseFor :: String -> String
responseFor statement
  | isSilence = "Fine. Be that way!"
  | isForcefulQuestion = "Calm down, I know what I'm doing!"
  | isQuestion = "Sure."
  | isShouting = "Whoa, chill out!"
  | otherwise = "Whatever."
  where
    text = filter (not . isSpace) statement
    letters = filter isLetter text
    isSilence = null text
    isForcefulQuestion = isQuestion && isShouting
    isShouting = all isUpper letters && any isUpper letters
    isQuestion = "?" `isSuffixOf` text
