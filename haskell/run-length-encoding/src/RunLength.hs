module RunLength (decode, encode) where

import Data.Char (isDigit)
import Data.List (group, groupBy)

decode :: String -> String
decode = concatMap decodeGroup . groupByCount
  where
    groupByCount = reverse . map toGroup . groupBy includeDigits . reverse
    decodeGroup (char, count) = replicate count char
    toGroup [char] = (char, 1)
    toGroup (char:reversedCount) = (char, (read . reverse) reversedCount)
    includeDigits _ = isDigit

encode :: String -> String
encode = concatMap encodeGroup . group
  where
    encodeGroup [char] = [char]
    encodeGroup g = show (length g) ++ [head g]