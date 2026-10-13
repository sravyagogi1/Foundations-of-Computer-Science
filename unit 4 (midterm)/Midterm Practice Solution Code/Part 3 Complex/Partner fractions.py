def reduce_h(fraction_string):
    fraction_parts = fraction_string.split('/')
    n = int(fraction_parts[0])
    d = int(fraction_parts[1])
    start = min(n, d)
    for poss_factor in range(start, 1, -1):
        if n % poss_factor == 0 and d % poss_factor == 0:
            n = n // poss_factor
            d = d // poss_factor
            break
    return str(n) + "/" + str(d)

def multiply_h(fraction_one, fraction_two):
    fraction_parts = fraction_one.split('/')
    n1 = int(fraction_parts[0])
    d1 = int(fraction_parts[1])
    fraction_parts = fraction_two.split('/')
    n2 = int(fraction_parts[0])
    d2 = int(fraction_parts[1])
    n = n1 * n2
    d = d1 * d2
    temp = str(n) + "/" + str(d)
    return reduce_h(temp)

def divide_h(fraction_one, fraction_two):
    fraction_parts = fraction_one.split('/')
    n1 = int(fraction_parts[0])
    d1 = int(fraction_parts[1])
    fraction_parts = fraction_two.split('/')
    d2 = int(fraction_parts[0])
    n2 = int(fraction_parts[1])
    n = n1 * n2
    d = d1 * d2
    temp = str(n) + "/" + str(d)
    return reduce_h(temp)

def add_h(fraction_one, fraction_two):
    fraction_parts = fraction_one.split('/')
    n1 = int(fraction_parts[0])
    d1 = int(fraction_parts[1])
    fraction_parts = fraction_two.split('/')
    n2 = int(fraction_parts[0])
    d2 = int(fraction_parts[1])
    n = n1 * d2 + n2 * d1
    d = d1 * d2
    temp = str(n) + "/" + str(d)
    return reduce_h(temp)

def sub_h(fraction_one, fraction_two):
    fraction_parts = fraction_one.split('/')
    n1 = int(fraction_parts[0])
    d1 = int(fraction_parts[1])
    fraction_parts = fraction_two.split('/')
    n2 = int(fraction_parts[0])
    d2 = int(fraction_parts[1])
    n = n1 * d2 - n2 * d1
    d = d1 * d2
    temp = str(n) + "/" + str(d)
    return reduce_h(temp)

def solve_fraction_problem(st):
    problem_parts = st.split()
    f1 = problem_parts[0]
    op = problem_parts[1]
    f2 = problem_parts[2]
    if op == "+":
        return add_h(f1, f2)
    elif op == "-":
        return sub_h(f1, f2)
    elif op == "*":
        return multiply_h(f1, f2)
    elif op == "/":
        return divide_h(f1, f2)


print(solve_fraction_problem("1/2 + 1/3"))
print(solve_fraction_problem("3/10 - 1/5"))
print(solve_fraction_problem("3/4 * 4/5"))
print(solve_fraction_problem("2/3 / 1/2"))