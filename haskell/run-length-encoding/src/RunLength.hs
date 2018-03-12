module RunLength (decode, encode) where

import Data.Char (isDigit, digitToInt)

decode :: String -> String
decode xs = decode' 0 [] xs

decode' :: Int -> String -> String -> String
decode' _ acc [] = acc
decode' howMany acc (x:xs)
  | isDigit x = decode' (10 * howMany + digitToInt x) acc xs
  | howMany == 0 = decode' 0 (acc ++ [x]) xs
  | otherwise = decode' 0 (acc ++ replicate howMany x) xs

encode :: String -> String
encode "" = ""
