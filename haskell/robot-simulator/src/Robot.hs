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
  , coordinates :: (Integer, Integer)
  }

mkRobot :: Bearing -> (Integer, Integer) -> Robot
mkRobot direction coordinates = Robot {bearing = direction, coordinates = coordinates}

simulate :: Robot -> String -> Robot
simulate robot instructions = error "You need to implement this function."

turnLeft :: Bearing -> Bearing
turnLeft direction = error "You need to implement this function."

turnRight :: Bearing -> Bearing
turnRight direction = error "You need to implement this function."