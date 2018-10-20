module House
  ( rhyme
  ) where

import           Data.List (intercalate)

verse :: Int -> [String]
--don't try this at home
--verse = (:) <$> start <*> remaining
verse num = start num : remaining num

start :: Int -> String
start num = "This is the " ++ fst (thing num)

remaining :: Int -> [String]
remaining num = map createLine [num,num - 1 .. 1]

createLine :: Int -> String
createLine num = "that " ++ that ++ " the " ++ the
  where
    that :: String
    that = snd $ thing num
    the :: String
    the = fst $ thing (num - 1)

thing :: Int -> (String, String)
thing num = things !! num

things :: [(String, String)]
things =
  [ ("house that Jack built.", "")
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
rhyme = intercalate "\n" $ map (unlines . verse) [0 .. length things - 1]