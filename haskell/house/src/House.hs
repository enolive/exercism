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
remaining 1 = ["that " ++ snd (thing 1)]
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
         , ("cow with the crumpled horn", "kicked")
         , ("maiden all forlorn", "milked")
         , ("man all tattered and torn", "kissed")
         , ("priest all shaven and shorn", "married")
         , ("rooster that crowed in the morn", "waked")
         , ("farmer sowing his corn", "kept")
         , ("horse and the hound and the horn", "belonged")
  ]

rhyme :: String
rhyme =
  "This is the house that Jack built.\n\
        \\n\
        \This is the malt\n\
        \that lay in the house that Jack built.\n\
        \\n\
        \This is the rat\n\
        \that ate the malt\n\
        \that lay in the house that Jack built.\n\
        \\n\
        \This is the cat\n\
        \that killed the rat\n\
        \that ate the malt\n\
        \that lay in the house that Jack built.\n\
        \\n\
        \This is the dog\n\
        \that worried the cat\n\
        \that killed the rat\n\
        \that ate the malt\n\
        \that lay in the house that Jack built.\n\
        \\n\
        \This is the cow with the crumpled horn\n\
        \that tossed the dog\n\
        \that worried the cat\n\
        \that killed the rat\n\
        \that ate the malt\n\
        \that lay in the house that Jack built.\n\
        \\n\
        \This is the maiden all forlorn\n\
        \that milked the cow with the crumpled horn\n\
        \that tossed the dog\n\
        \that worried the cat\n\
        \that killed the rat\n\
        \that ate the malt\n\
        \that lay in the house that Jack built.\n\
        \\n\
        \This is the man all tattered and torn\n\
        \that kissed the maiden all forlorn\n\
        \that milked the cow with the crumpled horn\n\
        \that tossed the dog\n\
        \that worried the cat\n\
        \that killed the rat\n\
        \that ate the malt\n\
        \that lay in the house that Jack built.\n\
        \\n\
        \This is the priest all shaven and shorn\n\
        \that married the man all tattered and torn\n\
        \that kissed the maiden all forlorn\n\
        \that milked the cow with the crumpled horn\n\
        \that tossed the dog\n\
        \that worried the cat\n\
        \that killed the rat\n\
        \that ate the malt\n\
        \that lay in the house that Jack built.\n\
        \\n\
        \This is the rooster that crowed in the morn\n\
        \that woke the priest all shaven and shorn\n\
        \that married the man all tattered and torn\n\
        \that kissed the maiden all forlorn\n\
        \that milked the cow with the crumpled horn\n\
        \that tossed the dog\n\
        \that worried the cat\n\
        \that killed the rat\n\
        \that ate the malt\n\
        \that lay in the house that Jack built.\n\
        \\n\
        \This is the farmer sowing his corn\n\
        \that kept the rooster that crowed in the morn\n\
        \that woke the priest all shaven and shorn\n\
        \that married the man all tattered and torn\n\
        \that kissed the maiden all forlorn\n\
        \that milked the cow with the crumpled horn\n\
        \that tossed the dog\n\
        \that worried the cat\n\
        \that killed the rat\n\
        \that ate the malt\n\
        \that lay in the house that Jack built.\n\
        \\n\
        \This is the horse and the hound and the horn\n\
        \that belonged to the farmer sowing his corn\n\
        \that kept the rooster that crowed in the morn\n\
        \that woke the priest all shaven and shorn\n\
        \that married the man all tattered and torn\n\
        \that kissed the maiden all forlorn\n\
        \that milked the cow with the crumpled horn\n\
        \that tossed the dog\n\
        \that worried the cat\n\
        \that killed the rat\n\
        \that ate the malt\n\
        \that lay in the house that Jack built.\n"
