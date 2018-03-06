module Phone (number) where

import Text.Regex.Posix ((=~)) -- from regex-posix

number :: String -> Maybe String
number xs = getMatch $ cleanNumber xs =~ pat

getMatch :: (String, String, String, [String]) -> Maybe String
getMatch (_, _, _, []) = Nothing
getMatch (_, _, _, groups) = Just $ groups !! 1

pat :: String
pat = "^(1)?(([2-9][0-9]{2})([2-9][0-9]{6}))$"

cleanNumber :: String -> String
cleanNumber = filter (`notElem` "+() -.")