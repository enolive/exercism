module Triangle
  ( rows
  ) where

rows :: Int -> [[Integer]]
rows n
  | n <= 0 = []
  | otherwise = map row [1 .. n]

row :: Int -> [Integer]
row 1 = [1]
row n = (addNumbers . row) (n - 1)

addNumbers :: [Integer] -> [Integer]
addNumbers xs = zipWith (+) xs' (reverse xs')
  where
    xs' = 0 : xs
