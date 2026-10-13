def contains(n, digit):
    while n > 0:
        if n % 10 == digit:
            return True
        n = n // 10
    return False

def sum_contains(digit, maximum):
    sum = 0
    for i in range(maximum + 1):
        if contains(i, digit):
            sum += i
    return sum

print(sum_contains(1, 15))