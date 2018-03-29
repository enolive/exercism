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
import Data.Maybe (fromJust, fromMaybe, isNothing)

data LinkedList a = LinkedList
  { rest :: Maybe (LinkedList a)
  , current :: Maybe a
  } deriving (Eq, Show)

datum :: LinkedList a -> a
datum = fromJust . current

fromList :: [a] -> LinkedList a
fromList = foldr new nil

isNil :: LinkedList a -> Bool
isNil = isNothing . rest

new :: a -> LinkedList a -> LinkedList a
new x linkedList = LinkedList {current = Just x, rest = Just linkedList}

next :: LinkedList a -> LinkedList a
next = fromMaybe nil . rest

nil :: LinkedList a
nil = LinkedList {current = Nothing, rest = Nothing}

reverseLinkedList :: LinkedList a -> LinkedList a
reverseLinkedList = fromList . reverse . toList

toList :: LinkedList a -> [a]
toList = unfoldr getElem
  where
    getElem linkedList
      | isNil linkedList = Nothing
      | otherwise = Just (datum linkedList, next linkedList)