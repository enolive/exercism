module Strain (keep, discard) where

discard :: (a -> Bool) -> [a] -> [a]
discard p xs = error "You need to implement this function."

keep :: (a -> Bool) -> [a] -> [a]
keep p = foldl (\ acc current -> if p current then acc ++ [current] else acc) []

