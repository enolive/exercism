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

import Data.Maybe

data LinkedList a = LinkedList {
  rest :: Maybe (LinkedList a),
  current :: Maybe a
} deriving (Eq, Show)

datum :: LinkedList a -> a
datum = fromJust . current

fromList :: [a] -> LinkedList a
fromList xs = error "You need to implement this function."

isNil :: LinkedList a -> Bool
isNil = isNothing . rest

new :: a -> LinkedList a -> LinkedList a
new x linkedList = LinkedList { current = Just x, rest = Just linkedList }

next :: LinkedList a -> LinkedList a
next = fromMaybe nil . rest

nil :: LinkedList a
nil = LinkedList { current = Nothing, rest = Nothing }

reverseLinkedList :: LinkedList a -> LinkedList a
reverseLinkedList linkedList = error "You need to implement this function."

toList :: LinkedList a -> [a]
toList linkedList = error "You need to implement this function."
