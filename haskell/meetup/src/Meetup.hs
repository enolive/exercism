module Meetup (Weekday(..), Schedule(..), meetupDay) where

import Data.Time.Calendar (Day, fromGregorian)
import Data.Time.Calendar.WeekDate (toWeekDate)

data Weekday = Monday
             | Tuesday
             | Wednesday
             | Thursday
             | Friday
             | Saturday
             | Sunday
             deriving (Show, Eq)

data Schedule = First
              | Second
              | Third
              | Fourth
              | Last
              | Teenth

meetupDay :: Schedule -> Weekday -> Integer -> Int -> Day
meetupDay schedule weekday year month = fromGregorian year month $ day schedule
  where
    day Teenth = getDay 0 [13 .. 19]
    day First = getDay 0 [1 .. 31]
    day Second = getDay 1 [1 .. 31]
    day Third = getDay 2 [1 .. 31]
    getDay dropWeeks = (!! dropWeeks) . filter (matches weekday year month)

getWeekDay :: Int -> Weekday
getWeekDay 1 = Monday
getWeekDay 2 = Tuesday
getWeekDay 3 = Wednesday
getWeekDay 4 = Thursday
getWeekDay 5 = Friday
getWeekDay 6 = Saturday
getWeekDay 7 = Sunday
getWeekDay _ = error "invalid day"

matches :: Weekday -> Integer -> Int -> Int -> Bool
matches expected year month dayOfMonth = getWeekDay weekDay == expected
  where
    (_, _, weekDay) = toWeekDate $ fromGregorian year month dayOfMonth
