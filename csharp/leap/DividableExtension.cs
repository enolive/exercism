public static class DividableExtension
{
    public static bool IsDividableBy(this int year, int divisor)
    {
        return year % divisor == 0;
    }
}