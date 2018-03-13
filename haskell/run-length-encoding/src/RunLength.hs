module RunLength (decode, encode) where

import Data.Char (isDigit)
import Data.List (group, groupBy)

decode :: String -> String
decode = concatMap decodeGroup . groupByCount
  where
    groupByCount = reverse . map toGroup . groupBy includeFollowingDigits . reverse
    decodeGroup (char, count) = replicate count char
    toGroup [char] = (char, 1)
    toGroup (char:reversedCount) = (char, (read . reverse) reversedCount)
    includeFollowingDigits _ = isDigit

encode :: String -> String
encode = concatMap encodeGroup . group
  where
    encodeGroup [char] = [char]
    encodeGroup g = show (length g) ++ [head g]