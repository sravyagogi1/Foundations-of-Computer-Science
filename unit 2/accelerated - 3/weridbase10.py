def weird_base(num):
    base5 = {'2': 0, '1': 1, '0': 2, '-': -1, '=': -2}
    result = 0

    for digit in num:
        if digit == num[-1]:
            result = result * 5 + int(digit)
        else:
            result = result * 5 + base5[digit]
    return result

print(weird_base('1=-2')) 