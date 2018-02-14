module SpaceAge (Planet(..), ageOn) where

data Planet = Mercury
            | Venus
            | Earth
            | Mars
            | Jupiter
            | Saturn
            | Uranus
            | Neptune
            deriving (Eq)

ageOn :: Planet -> Float -> Float
ageOn planet seconds
    | planet == Earth = seconds / 365.25 / 24 / 60 / 60
    | otherwise = 42.0