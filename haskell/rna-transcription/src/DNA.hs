module DNA
  ( toRNA
  ) where

toRNA :: String -> Maybe String
toRNA = mapM item
  where
    item 'C' = Just 'G'
    item 'G' = Just 'C'
    item 'T' = Just 'A'
    item 'A' = Just 'U'
    item _ = Nothing