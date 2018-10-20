module House
  ( rhyme
  ) where

import Data.List (intercalate)

verse :: Int -> [String]
verse = mergeLastTwo . verse'

mergeLastTwo :: [String] -> [String]
mergeLastTwo lines = take allButLast2 lines ++ [(unwords . drop allButLast2) lines]
  where
    allButLast2 = length lines - 2

verse' :: Int -> [String]
verse' num = start num : remaining num

start :: Int -> String
start num = "This is the " ++ fst (thing num)

remaining :: Int -> [String]
remaining 1 = ["that " ++ snd (thing 1) ++ "."]
remaining num = current : remaining (num - 1)
  where
    current = "that " ++ that ++ " the " ++ the
    that = snd $ thing num
    the = fst $ thing (num - 1)

thing :: Int -> (String, String)
thing num = things !! (num - 1)

things :: [(String, String)]
things = [ ("house", "Jack built")
         , ("malt", "lay in")
         , ("rat", "ate")
         , ("cat", "killed")
         , ("dog", "worried")
         , ("cow with the crumpled horn", "tossed")
         , ("maiden all forlorn", "milked")
         , ("man all tattered and torn", "kissed")
         , ("priest all shaven and shorn", "married")
         , ("rooster that crowed in the morn", "woke")
         , ("farmer sowing his corn", "kept")
         , ("horse and the hound and the horn", "belonged to")
  ]

rhyme :: String
rhyme = intercalate "\n" $ map (unlines . verse) [1..length things]