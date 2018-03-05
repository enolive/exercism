module Strain
  ( keep
  , discard
  ) where

discard :: (a -> Bool) -> [a] -> [a]
discard p = keep (not . p)

keep :: (a -> Bool) -> [a] -> [a]
keep predicate = foldr (prependIf predicate) []

prependIf :: (a -> Bool) -> a -> [a] -> [a]
prependIf predicate current
  | predicate current = (current:)
  | otherwise = id