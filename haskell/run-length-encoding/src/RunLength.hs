module RunLength (decode, encode) where

import Data.Char (isDigit, digitToInt)
import Data.List (group, groupBy)

decode :: String -> String
decode [] = []
decode xs = reverse $ concatMap decodeGroup $ (groupBy includeDigits . reverse) xs
  where
    includeDigits _ = isDigit
    decodeGroup [char] = [char]
    decodeGroup (char:reversedCount) = replicate (read $ reverse reversedCount) char

encode :: String -> String
encode xs = concatMap encodeGroup $ group xs
  where
    encodeGroup [char] = [char]
    encodeGroup g = show (length g) ++ [head g]
