module Meetup
  ( Weekday(..)
  , Schedule(..)
  , meetupDay
  ) where

import Data.Time.Calendar (Day, fromGregorian, gregorianMonthLength)
import Data.Time.Calendar.WeekDate (toWeekDate)

data Weekday
  = Monday
  | Tuesday
  | Wednesday
  | Thursday
  | Friday
  | Saturday
  | Sunday
  deriving (Show, Eq)

data Schedule
  = First
  | Second
  | Third
  | Fourth
  | Last
  | Teenth

meetupDay :: Schedule -> Weekday -> Integer -> Int -> Day
meetupDay schedule weekday year month = fromGregorian year month $ day schedule
  where
    day Teenth = findDay head [13 .. 19]
    day First = findDay head daysOfMonth
    day Second = findDay (!! 1) daysOfMonth
    day Third = findDay (!! 2) daysOfMonth
    day Fourth = findDay (!! 3) daysOfMonth
    day Last = findDay last daysOfMonth
    daysOfMonth = [1..gregorianMonthLength year month]
    findDay f = f . daysForWeekday
    daysForWeekday = filter (matches weekday year month)

matches :: Weekday -> Integer -> Int -> Int -> Bool
matches expectedWeekDay year month dayOfMonth = getWeekDay weekDay == expectedWeekDay
  where
    (_, _, weekDay) = toWeekDate $ fromGregorian year month dayOfMonth

getWeekDay :: Int -> Weekday
getWeekDay dayNumber =
  case dayNumber of
    1 -> Monday
    2 -> Tuesday
    3 -> Wednesday
    4 -> Thursday
    5 -> Friday
    6 -> Saturday
    7 -> Sunday
    _ -> error "invalid day"