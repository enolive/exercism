module RunLength (decode, encode) where

import Data.Char (isDigit, digitToInt)

decode :: String -> String
decode [] = []
decode xs = replicate howMany current ++ decode rest
  where
    howMany = if null digits then 1 else read digits
    rest = tail characters
    current = head characters
    characters = drop (length digits) xs
    digits = takeWhile isDigit xs

encode :: String -> String
encode [] = []
encode xs = showHowMany ++ [current] ++ encode differentCharacters
  where
    showHowMany = if howMany == 1 then "" else show howMany
    howMany = length xs - length differentCharacters
    differentCharacters = dropWhile (== current) xs
    current = head xs
