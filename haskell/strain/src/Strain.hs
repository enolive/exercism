module Strain
  ( keep
  , discard
  ) where

discard :: (a -> Bool) -> [a] -> [a]
discard p = keep (not . p)

keep :: (a -> Bool) -> [a] -> [a]
keep predicate = foldr (appendIf predicate) []

appendIf :: (a -> Bool) -> a -> [a] -> [a]
appendIf predicate current
  | predicate current = (current:)
  | otherwise = id