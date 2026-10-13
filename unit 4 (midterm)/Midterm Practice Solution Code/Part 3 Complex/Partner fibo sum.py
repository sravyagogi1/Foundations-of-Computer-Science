def fibo_list_h(n):
    fibos = [1,1]
    while fibos[-1] <= n:
        fibos.append(fibos[-1] + fibos[-2])
    return fibos[:-1]

def minus_largest_fibo_h(n):
    fibo_list = fibo_list_h(n)
    return_list = []
    return_list.append(fibo_list[-1])
    return_list.append(n - fibo_list[-1])
    return return_list

def make_fibo_sum(n):
    return_list = []
    while n > 0:
        minus_largest = minus_largest_fibo_h(n)
        return_list.insert(0, minus_largest[0])
        n = minus_largest[1]
    return return_list

print(make_fibo_sum(17))
print(make_fibo_sum(55))
print(make_fibo_sum(1))