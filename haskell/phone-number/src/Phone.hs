module Phone (number) where

number :: String -> Maybe String
number xs = clean <$> Just xs

clean :: String -> String
clean = filter (not . isPunctuation)

isPunctuation :: Char -> Bool
isPunctuation c = c `elem` "() -."
