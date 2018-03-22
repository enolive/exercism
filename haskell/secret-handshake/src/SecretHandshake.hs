module SecretHandshake
  ( handshake
  ) where

import Data.Bits (testBit)

handshake :: Int -> [String]
handshake number
  | testBit number 4 = reverse list
  | otherwise = list
  where
    list = concatMap bitMeaning $ bitsFor number
    bitMeaning = toList . bitToString

bitsFor :: Int -> [Int]
bitsFor number = filter (testBit number) [0 .. 3]

toList :: a -> [a]
toList elem = [elem]

bitToString :: Int -> String
bitToString 0 = "wink"
bitToString 1 = "double blink"
bitToString 2 = "close your eyes"
bitToString 3 = "jump"