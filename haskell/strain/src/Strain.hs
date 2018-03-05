module Strain (keep, discard) where

discard :: (a -> Bool) -> [a] -> [a]
discard p xs = error "You need to implement this function."

keep :: (a -> Bool) -> [a] -> [a]
keep = keep' []

keep' acc _ [] = acc
keep' acc p (x:xs)
  | p x = keep' (acc ++ [x]) p xs
  | otherwise = keep' acc p xs

