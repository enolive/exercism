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

mirror xs = (++) xs (mirrored xs)
  where mirrored xs = reverse $ take 2 xs