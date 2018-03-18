module ComplexNumbers
  ( Complex(..)
  , conjugate
  , abs
  , mul
  , add
  , sub
  , div
  , complex
  ) where

import Prelude hiding (abs, div)

-- Data definition -------------------------------------------------------------
data Complex a = Complex
  { real :: a
  , imaginary :: a
  } deriving (Eq, Show)

complex :: (a, a) -> Complex a
complex (real, imaginary) = Complex real imaginary

-- unary operators -------------------------------------------------------------
conjugate :: Num a => Complex a -> Complex a
conjugate (Complex a b) = Complex a (-b)

abs :: Floating a => Complex a -> a
abs (Complex a b) = sqrt (a^2 + b^2)

reciprocal :: Fractional a => Complex a -> Complex a
reciprocal (Complex a b) = Complex (a/(a^2 + b^2)) (-b/(a^2 + b^2))

-- binary operators ------------------------------------------------------------
mul :: Num a => Complex a -> Complex a -> Complex a
mul (Complex a b) (Complex c d) = Complex (a * c - b * d) (b * c + a * d)

add :: Num a => Complex a -> Complex a -> Complex a
add (Complex a b) (Complex c d) = Complex (a + c) (b + d)

sub :: Num a => Complex a -> Complex a -> Complex a
sub (Complex a b) (Complex c d) = Complex (a - c) (b - d)

div :: Fractional a => Complex a -> Complex a -> Complex a
div a b = mul a $ reciprocal b