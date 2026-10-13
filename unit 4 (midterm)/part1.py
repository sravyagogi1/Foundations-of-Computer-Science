def mult_3_5(n):
    if n % 3 == 0:
        return True 
    elif n % 5 == 0:
        return True
    else:
        return False

def sum_3_5(n):
    if n == 0:
        return 0
    elif mult_3_5(n):
        return n + sum_3_5(n-1)
    elif not mult_3_5(n):
        return sum_3_5(n - 1)

print(sum_3_5(6))


def replace_before(st):
    t = list(st)
    for index, character in enumerate(t):
        if character in "aeiouAEIOU" and index != 0:
            t[index - 1] = "!"
    return "".join(t) 

print("hello")