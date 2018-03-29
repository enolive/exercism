module LinkedList
  ( LinkedList
  , datum
  , fromList
  , isNil
  , new
  , next
  , nil
  , reverseLinkedList
  , toList
  ) where

import Data.List (unfoldr)

data LinkedList a = Nil | Item a (LinkedList a) deriving (Eq, Show)

datum :: LinkedList a -> a
datum (Item x _) = x
datum Nil = error "nil has no entry"

fromList :: [a] -> LinkedList a
fromList = foldr new nil

isNil :: LinkedList a -> Bool
isNil Nil = True
isNil _ = False

new :: a -> LinkedList a -> LinkedList a
new = Item

next :: LinkedList a -> LinkedList a
next Nil = Nil
next (Item _ linkedList) = linkedList

nil :: LinkedList a
nil = Nil

reverseLinkedList :: LinkedList a -> LinkedList a
reverseLinkedList = fromList . reverse . toList

toList :: LinkedList a -> [a]
toList = unfoldr getElem
  where
    getElem Nil = Nothing
    getElem (Item a linkedList) = Just (a, linkedList)