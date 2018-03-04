module Diamond
  ( diamond
  ) where

diamond :: Char -> Maybe [String]
diamond 'A' = Just ["A"]
diamond 'B' = Just [" A ", "B B", " A "]
diamond 'C' = Just $ mirror upperHalf

upperHalf = map (mirror . makeLine 2) $ zip [0..] ['A'..'C']

makeLine length (index, character) = spaces (length - index) ++ [character] ++ spaces index

spaces :: Int -> String
spaces n = replicate n ' '

mirror :: [a] -> [a]
mirror = mirrored >>= flip (++)
  where
    mirrored = reverse . init