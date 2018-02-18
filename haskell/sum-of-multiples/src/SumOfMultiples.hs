module SumOfMultiples
  ( sumOfMultiples
  ) where

import qualified Data.Set as Set

sumOfMultiples :: [Integer] -> Integer -> Integer
sumOfMultiples factors limit = sum $ foldl Set.union Set.empty $ fmap multiplesOf factors
  where
    multiplesOf n = Set.fromList $ takeWhile (< limit) $ fmap (n *) [1 ..]