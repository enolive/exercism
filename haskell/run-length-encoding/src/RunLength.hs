module RunLength (decode, encode) where

import Data.Char (isDigit)
import Data.List (group, groupBy)

type DecodeTuple = (Int, Char)

decode :: String -> String
decode = concatMap decodePair . foldPairs

decodePair :: DecodeTuple -> String
decodePair = uncurry replicate

foldPairs :: String -> [DecodeTuple]
foldPairs = snd . foldl listToPairs (Nothing, []) . groupBy allNumbers

listToPairs :: (Maybe String, [DecodeTuple]) -> String -> (Maybe String, [DecodeTuple])
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