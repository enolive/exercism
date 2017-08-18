public static class Leap
{
    public static bool IsLeapYear(int year)
    {
        return year.IsDividableBy(400) || !year.IsDividableBy(100) && year.IsDividableBy(4);
    }
}