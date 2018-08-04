{-# LANGUAGE RecordWildCards #-}

module Robot
  ( Bearing(East, North, South, West)
  , bearing
  , coordinates
  , mkRobot
  , simulate
  , turnLeft
  , turnRight
  ) where

data Bearing
  = North
  | East
  | South
  | West
  deriving (Eq, Show)

data Robot = Robot
  { bearing :: Bearing
  , coordinates :: Position
  }

type Position = (Integer, Integer)

mkRobot :: Bearing -> Position -> Robot
mkRobot direction coordinates = Robot {bearing = direction, coordinates = coordinates}

simulate :: Robot -> String -> Robot
simulate = foldl (flip move)

move :: Char ->  Robot -> Robot
move 'A' = advance
move 'L' = changeBearing turnLeft
move 'R' = changeBearing turnRight

changeBearing :: (Bearing -> Bearing) -> Robot -> Robot
changeBearing f Robot {..} = mkRobot (f bearing) coordinates

advance :: Robot -> Robot
advance Robot {bearing = dir, coordinates = (x, y)} = mkRobot dir $ changeCoordinates dir (x, y)

changeCoordinates :: Bearing -> Position -> Position
changeCoordinates North (x, y) = (x, y + 1)
changeCoordinates South (x, y) = (x, y - 1)
changeCoordinates East (x, y) = (x + 1, y)
changeCoordinates West (x, y) = (x - 1, y)

turnLeft :: Bearing -> Bearing
turnLeft North = West
turnLeft West = South
turnLeft South = East
turnLeft East = North

turnRight :: Bearing -> Bearing
turnRight North = East
turnRight East = South
turnRight South = West
turnRight West = North