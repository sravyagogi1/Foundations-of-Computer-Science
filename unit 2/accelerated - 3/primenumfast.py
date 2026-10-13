def is_prime(num):
    if num <= 1:
        return False
    if num % 2 == 0:
        return False
    for i in range(3, int(num**0.5) + 1, 2):
        if num % i == 0:
            return False
    return True

def prime_pairs(n):
    count = 0

    for i in range(2, n):
        if is_prime(i) and is_prime(i + 2):
            count += 1

    return count

print(prime_pairs(1000000))