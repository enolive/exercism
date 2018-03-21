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
simulate robot [] = robot
simulate robot (command:commandList) = (simulate . perform command) robot commandList

perform :: Char -> Robot -> Robot
perform 'A' = advance
perform 'L' = changeBearing turnLeft
perform 'R' = changeBearing turnRight

changeBearing :: (Bearing -> Bearing) -> Robot -> Robot
changeBearing f Robot {bearing = dir, coordinates = location} = mkRobot (f dir) location

advance :: Robot -> Robot
advance (Robot dir (x, y)) = mkRobot dir newCoordinates
  where
    newCoordinates =
      case dir of
        North -> (x, y + 1)
        South -> (x, y - 1)
        East -> (x + 1, y)
        West -> (x - 1, y)

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