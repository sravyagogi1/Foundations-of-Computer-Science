def fib(n):
    if n == 0:
        return 1
    if n == 1:
        return 1
    return fib(n-1)+fib(n-2)
#print (fib(40))


def fib_helper(n, prev, cur):
    if n == 0:
        return 1
    if n == 1:
        return 1
    return fib(n-1)+fib(n-2)
def fib(n):
    return fib_helper(n,0,1)
#print (fib(40))

('''The second version runs much faster that version 1 because
the frist one is counting the fibbinnaci sequence for every 
single number's previous number every single time. The second 
version is much faster since it has a list of initial arguments
that we don't need to run over again''')


def fib(n, prev, cur):
    if n < 0:
        return False
    if n == cur:
        return True
    if n > cur:
        return fib(n, cur, prev + cur)
    else:
        return False
def is_fib(n):
     return fib(n,0,1)
#print (is_fib(1))


def sum_even_fib(n, prev, cur):
    if n < cur:
        return 0
    if cur % 2 == 0:
        return cur + sum_even_fib(n, cur, prev + cur)
    else:
        return sum_even_fib(n, cur, prev + cur)
def is_fib(n):
    return sum_even_fib(n,0,1)
#print (is_fib(10))