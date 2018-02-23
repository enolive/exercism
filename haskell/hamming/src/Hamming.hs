module Hamming
  ( distance
  ) where

distance :: String -> String -> Maybe Int
distance xs ys = Just $ length $ filter areDifferent $ zip xs ys
  where
    areDifferent :: (Char, Char) -> Bool
    areDifferent (x, y) = x /= y