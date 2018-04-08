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
meetupDay Teenth Monday 2013 5 = fromGregorian 2013 5 13
meetupDay Teenth Monday 2013 8 = fromGregorian 2013 8 19
meetupDay Teenth Monday 2013 9 = fromGregorian 2013 9 16
meetupDay schedule weekday year month = fromGregorian year month 1

getWeekDay 1 = Monday
getWeekDay 2 = Tuesday
getWeekDay 3 = Wednesday
getWeekDay 4 = Thursday
getWeekDay 5 = Friday
getWeekDay 6 = Saturday
getWeekDay 7 = Sunday

matches :: Weekday -> Integer -> Int -> Int -> Bool
matches expected year month dayOfMonth = getWeekDay weekDay == expected
  where
    (_, _, weekDay) = toWeekDate $ fromGregorian year month dayOfMonth
