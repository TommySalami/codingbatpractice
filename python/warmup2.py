def string_times(str, n):
    """Given a string and a non-negative int n, return a larger string that is
    n copies of the original string."""
    return str * n


def front_times(str, n):
    """Given a string and a non-negative int n, we'll say that the front of
    the string is the first 3 chars, or whatever is there if the string is
    less than length 3. Return n copies of the front;"""
    if len(str) < 3:
        return str * n
    else:
        return str[:3] * n


def string_bits(str):
    """Given a string, return a new string made of every other char starting
    with the first, so "Hello" yields "Hlo"."""
    if len(str) < 2:
        return str
    else:
        return str[::2]


def string_splosion(str):
    """Given a non-empty string like "Code" return a string like "CCoCodCode"."""

    splosion = ""
    for i in range(1, len(str) + 1):
        splosion += str[0:i]

    return splosion


def last2(str):
    """Given a string, return the count of the number of times that a substring
    length 2 appears in the string and also as the last 2 chars of the string,
    so "hixxxhi" yields 1 (we won't count the end substring)."""
    if len(str) < 3:
        return 0

    count = 0
    substr = str[-2:]

    for i in range(0, len(str) - 2):
        if str[i:i + 2] == substr:
            count += 1
    return count


def array_count9(nums):
    """Given an array of ints, return the number of 9's in the array."""
    count = 0
    for element in nums:
        if element == 9:
            count += 1
    return count


def array_front9(nums):
    """Given an array of ints, return True if one of the first 4 elements
    in the array is a 9. The array length may be less than 4."""

