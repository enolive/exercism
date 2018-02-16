module Pangram
  ( isPangram
  ) where

isPangram :: String -> Bool
isPangram text
  | null text = False
  | otherwise = True