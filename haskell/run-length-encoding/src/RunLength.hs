module RunLength (decode, encode) where

import Data.Char (isDigit)
import Data.List (group, groupBy)

decode :: String -> String
decode = concatMap (uncurry replicate) . foldPairs

foldPairs :: String -> [(Int, Char)]
foldPairs = snd . foldl listToPairs (Nothing, []) . groupBy allNumbers

listToPairs :: (Maybe String, [(Int, Char)]) -> String -> (Maybe String, [(Int, Char)])
listToPairs (Just previousNumber, list) group
  = (Nothing, list ++ [(read previousNumber, head group)])
listToPairs (Nothing, list) group
  | (isDigit . head) group = (Just group, list)
  | otherwise = (Nothing, list ++ [(1, head group)])

allNumbers :: Char -> Char -> Bool
allNumbers a b = isDigit a && isDigit b

encode :: String -> String
encode = concatMap encodeGroup . group
  where
    encodeGroup [char] = [char]
    encodeGroup g@(char:_) = show (length g) ++ [char]