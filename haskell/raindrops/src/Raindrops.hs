module Raindrops (convert) where

convert :: Int -> String
convert input =
  [result | (appliesTo, result) <- rules, appliesTo input]
  `concatOrIfEmpty`
  show input

concatOrIfEmpty :: [String] -> String -> String
concatOrIfEmpty [] defaultValue = defaultValue
concatOrIfEmpty list _ = concat list

rules :: [(Int -> Bool, String)]
rules = [
  (divisibleBy 3, "Pling"),
  (divisibleBy 5, "Plang"),
  (divisibleBy 7, "Plong")
  ]

divisibleBy :: Int -> Int -> Bool
divisibleBy divisor input = input `mod` divisor == 0
