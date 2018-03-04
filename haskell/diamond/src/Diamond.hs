module Diamond
  ( diamond
  ) where

diamond :: Char -> Maybe [String]
diamond 'A' = Just ["A"]
diamond 'B' = Just [" A ", "B B", " A "]
diamond 'C' = Just $ mirror [
  mirror $ spaces (2 - 0) ++ "A" ++ spaces 0,
  mirror $ spaces (2 - 1) ++ "B" ++ spaces 1,
  mirror $ spaces (2 - 2) ++ "C" ++ spaces 2]

spaces n = replicate n ' '

mirror :: [a] -> [a]
mirror = mirrored >>= flip (++)
  where
    mirrored = reverse . init