{-# LANGUAGE RecordWildCards #-}

import Data.Foldable (for_)
import Diamond (diamond)
import Test.Hspec (Spec, describe, it, shouldBe)
import Test.Hspec.Runner (configFastFail, defaultConfig, hspecWith)

main :: IO ()
main = hspecWith defaultConfig {configFastFail = True} specs

specs :: Spec
specs = describe "diamond" $ for_ cases test
  where
    test Case {..} = it description assertion
      where
        assertion = diamond input `shouldBe` expected

data Case = Case
  { description :: String
  , input :: Char
  , expected :: Maybe [String]
  }

cases :: [Case]
cases =
  [ Case {description = "Value not in A..Z", input = '1', expected = Nothing}
  , Case {description = "Value is not upper char", input = 'a', expected = Nothing}
  , Case {description = "Degenerate case with a single 'A' row", input = 'A', expected = Just ["A"]}
  , Case
    { description = "Degenerate case with no row containing 3 distinct groups of spaces"
    , input = 'B'
    , expected = Just [" A ", "B B", " A "]
    }
  , Case
    { description = "Smallest non-degenerate case with odd diamond side length"
    , input = 'C'
    , expected = Just ["  A  ", " B B ", "C   C", " B B ", "  A  "]
    }
  , Case
    { description = "Smallest non-degenerate case with even diamond side length"
    , input = 'D'
    , expected = Just ["   A   ", "  B B  ", " C   C ", "D     D", " C   C ", "  B B  ", "   A   "]
    }
  , Case
    { description = "Largest possible diamond"
    , input = 'Z'
    , expected =
        Just
          [ "                         A                         "
          , "                        B B                        "
          , "                       C   C                       "
          , "                      D     D                      "
          , "                     E       E                     "
          , "                    F         F                    "
          , "                   G           G                   "
          , "                  H             H                  "
          , "                 I               I                 "
          , "                J                 J                "
          , "               K                   K               "
          , "              L                     L              "
          , "             M                       M             "
          , "            N                         N            "
          , "           O                           O           "
          , "          P                             P          "
          , "         Q                               Q         "
          , "        R                                 R        "
          , "       S                                   S       "
          , "      T                                     T      "
          , "     U                                       U     "
          , "    V                                         V    "
          , "   W                                           W   "
          , "  X                                             X  "
          , " Y                                               Y "
          , "Z                                                 Z"
          , " Y                                               Y "
          , "  X                                             X  "
          , "   W                                           W   "
          , "    V                                         V    "
          , "     U                                       U     "
          , "      T                                     T      "
          , "       S                                   S       "
          , "        R                                 R        "
          , "         Q                               Q         "
          , "          P                             P          "
          , "           O                           O           "
          , "            N                         N            "
          , "             M                       M             "
          , "              L                     L              "
          , "               K                   K               "
          , "                J                 J                "
          , "                 I               I                 "
          , "                  H             H                  "
          , "                   G           G                   "
          , "                    F         F                    "
          , "                     E       E                     "
          , "                      D     D                      "
          , "                       C   C                       "
          , "                        B B                        "
          , "                         A                         "
          ]
    }
  ]