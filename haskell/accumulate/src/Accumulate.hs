module Accumulate (accumulate) where

accumulate :: (a -> b) -> [a] -> [b]
accumulate f xs = foldr (\ current acc -> f current : acc) [] xs