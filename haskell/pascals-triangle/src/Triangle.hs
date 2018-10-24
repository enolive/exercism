module Triangle
  ( rows
  ) where

rows :: Int -> [[Integer]]
rows n = take n triangle

triangle :: [[Integer]]
triangle = [1] : map addNumbers triangle

addNumbers :: [Integer] -> [Integer]
addNumbers xs = zipWith (+) xs' (reverse xs')
  where
    xs' = 0 : xs
