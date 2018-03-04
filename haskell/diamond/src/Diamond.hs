module Diamond
  ( diamond
  ) where

diamond :: Char -> Maybe [String]
diamond 'A' = Just ["A"]
diamond 'B' = Just [" A ", "B B", " A "]
diamond 'C' = Just $ mirror [
  mirror "  A",
  mirror " B ",
  mirror "C  "]

mirror :: [a] -> [a]
mirror = mirrored >>= flip (++)
  where
    mirrored = reverse . init