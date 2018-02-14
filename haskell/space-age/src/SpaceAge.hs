module SpaceAge (Planet(..), ageOn) where

data Planet = Mercury
            | Venus
            | Earth
            | Mars
            | Jupiter
            | Saturn
            | Uranus
            | Neptune
            deriving (Enum)

timesEarth :: Planet -> Float
timesEarth planet = case planet of
    Earth -> 1
    Mercury -> 0.2408467

ageOn :: Planet -> Float -> Float
ageOn planet seconds =
    let yearOnEarth seconds = seconds / 365.25 / 24 / 60 / 60
    in yearOnEarth seconds / timesEarth planet