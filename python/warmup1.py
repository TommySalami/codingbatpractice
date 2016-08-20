def sleep_in(weekday, vacation):
    """The parameter weekday is True if it is a weekday, and the parameter vacation
    is True if we are on vacation. We sleep in if it is not a weekday or we're on
    vacation. Return True if we sleep in."""
    return vacation or not weekday


def monkey_trouble(a_smile, b_smile):
    """We have two monkeys, a and b, and the parameters a_smile and b_smile indicate
    if each is smiling. We are in trouble if they are both smiling or if neither of
    them is smiling. Return True if we are in trouble."""
    if a_smile and b_smile:
        return True
    return not a_smile and not b_smile


def sum_double(a, b):
    """Given two int values, return their sum. Unless the two values are the same,
    then return double their sum."""
    if a == b:
        return (a + b) * 2
    else:
        return a + b


def diff21(a):
    """Given an int n, return the absolute difference between n and 21, except
    return double the absolute difference if n is over 21."""
    if a > 21:
        return 2 * abs(a - 21)
    else:
        return abs(21 - a)


def parrot_trouble(talking, hour):
    """We have a loud talking parrot. The "hour" parameter is the current hour time
    in the range 0..23. We are in trouble if the parrot is talking and the hour is
    before 7 or after 20. Return True if we are in trouble."""
    return talking and (hour < 7 or hour > 20)


def makes10(a, b):
    """Given 2 ints, a and b, return True if one if them is 10 or if their sum is 10."""
    if a == 10 or b == 10:
        return True
    else:
        return a + b == 10


def near_hundred(a):
    """Given an int n, return True if it is within 10 of 100 or 200. Note: abs(num)
    computes the absolute value of a number."""
    return abs(a - 100) <= 10 or abs(a - 200) <= 10


def pos_neg(a, b, negative):
    """Given 2 int values, return True if one is negative and one is positive. Except
    if the parameter "negative" is True, then return True only if both are negative."""
    if negative:
        if a < 0 > b:
            return True
        else:
            return False
    elif (a < 0 < b) or (a > 0 > b):
        return True
    else:
        return False


def not_string(str):
    """Given a string, return a new string where "not " has been added to the front.
    However, if the string already begins with "not", return the string unchanged."""
    if str.startswith('not'):
        return str
    else:
        return 'not ' + str


def missing_char(str, n):
    """Given a non-empty string and an int n, return a new string where the char at
    index n has been removed. The value of n will be a valid index of a char in the
    original string (i.e. n will be in the range 0..len(str)-1 inclusive)."""
    