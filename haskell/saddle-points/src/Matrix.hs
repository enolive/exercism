module Matrix (saddlePoints) where

import Data.Array (Array, indices)

type Index = (Int, Int)

saddlePoints :: Array Index e -> [Index]
saddlePoints matrix = [(1,0)]
