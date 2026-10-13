"""I swear, on my honor, I did not google any solutions, algorithms, or Python code related to this
problem, or get another person to give me any solutions, algorithms or Python code related to this
problem. I solved it entirely myself. -Sravya Gogineni"""

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