module CollatzConjecture
  ( collatz
  ) where

import Control.Monad.State.Strict (State, evalState, get, put)

collatz :: Integer -> Maybe Integer
collatz n
  | n <= 0 = Nothing
  | otherwise = Just $ evalState (countSteps n) 0

countSteps :: Integer -> State Integer Integer
countSteps 1 = get
countSteps n = do
  acc <- get
  put (acc + 1)
  countSteps $
    if even n
      then n `div` 2
      else n * 3 + 1
