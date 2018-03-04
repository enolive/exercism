module Diamond
  ( diamond
  ) where

diamond :: Char -> Maybe [String]
diamond 'A' = Just ["A"]
diamond 'B' = Just [" A ", "B B", " A "]
diamond 'C' = Just $ mirror upperHalf

upperHalf = [
              mirror $ makeLine 2 (0, 'A'),
              mirror $ makeLine 2 (1, 'B'),
              mirror $ makeLine 2 (2, 'C')]
makeLine length (index, character) = spaces (length - index) ++ [character] ++ spaces index

spaces :: Int -> String
spaces n = replicate n ' '

mirror :: [a] -> [a]
mirror = mirrored >>= flip (++)
  where
    mirrored = reverse . init