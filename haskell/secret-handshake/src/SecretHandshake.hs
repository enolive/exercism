module SecretHandshake
  ( handshake
  ) where

import Data.Bits (testBit)

handshake :: Int -> [String]
handshake number = (reverseIfNecessary number . concatMap bitMeaning) $ bitsFor number
  where
    bitMeaning = toList . bitToString

reverseIfNecessary :: Int -> [a] -> [a]
reverseIfNecessary number input
  | testBit number 4 = reverse input
  | otherwise = input

bitsFor :: Int -> [Int]
bitsFor number = filter (testBit number) [0 .. 3]

toList :: a -> [a]
toList elem = [elem]

bitToString :: Int -> String
bitToString 0 = "wink"
bitToString 1 = "double blink"
bitToString 2 = "close your eyes"
bitToString 3 = "jump"