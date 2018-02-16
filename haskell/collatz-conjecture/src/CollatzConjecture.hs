module CollatzConjecture
  ( collatz
  ) where

import Control.Monad.State.Strict (State, evalState, get, modify, put)

collatz :: Integer -> Maybe Integer
collatz n
  | n <= 0 = Nothing
  | otherwise = Just $ evalState (collatzRec n) 0

collatzRec :: Integer -> State Integer Integer
collatzRec 1 = get
collatzRec n = do
  modify (+ 1)
  collatzRec $
    if even n
      then n `div` 2
      else n * 3 + 1