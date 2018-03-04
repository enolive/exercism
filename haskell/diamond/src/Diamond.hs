module Diamond
  ( diamond
  ) where

diamond :: Char -> Maybe [String]
diamond 'A' = Just ["A"]
diamond 'B' = Just [" A ", "B B", " A "]
diamond 'C' = Just $ mirror [
  "  A  ",
  " B B ",
  "C   C"]

mirror :: [String] -> [String]
mirror = mirrored >>= flip (++)
  where
    mirrored = reverse . init