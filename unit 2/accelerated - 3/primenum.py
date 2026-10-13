"""I swear, on my honor, I did not google any solutions, algorithms, or Python code related to this""
problem, or get another person to give me any solutions, algorithms or Python code related to this
problem. I solved it entirely myself. -Sravya Gogineni"""

def is_prime(num):
    if num <= 1:
        return False
    if num % 2 == 0:
        return False
    else:
        for i in range(2, int(num/2)+1):
            if num % i == 0:
                return False
        return True
 
def prime_pairs(n):
    count = 0
    for i in range(2, n):
        if is_prime(i) and is_prime(i+2):
            count += 1
    return count

print(prime_pairs(10000))