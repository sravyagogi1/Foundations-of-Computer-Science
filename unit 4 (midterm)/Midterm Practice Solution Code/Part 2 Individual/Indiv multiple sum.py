def multiple_sum(num1, num2, maximum):
    sum = 0
    for i in range(maximum + 1):
        if i % num1 == 0 or i % num2 == 0:
            sum += i
    return sum

print(multiple_sum(3, 5, 10))