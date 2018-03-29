module ListOps
  ( length
  , reverse
  , map
  , filter
  , foldr
  , foldl'
  , (++)
  , concat
  ) where

import Prelude hiding
  ( length, reverse, map, filter, foldr, (++), concat )

foldl' :: (b -> a -> b) -> b -> [a] -> b
foldl' f z xs = error "You need to implement this function."

foldr :: (a -> b -> b) -> b -> [a] -> b
foldr f z xs = error "You need to implement this function."

length :: [a] -> Int
length [] = 0
length (_:xs) = 1 + length xs

reverse :: [a] -> [a]
reverse [] = []
reverse (x:xs) = reverse xs ++ [x]

map :: (a -> b) -> [a] -> [b]
map f xs = error "You need to implement this function."

filter :: (a -> Bool) -> [a] -> [a]
filter p xs = error "You need to implement this function."

(++) :: [a] -> [a] -> [a]
[] ++ ys = ys
(x:xs) ++ (ys) = x : xs ++ ys

concat :: [[a]] -> [a]
concat xss = error "You need to implement this function."
