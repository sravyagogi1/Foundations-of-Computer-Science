def mystery(n):
    if n <= 2:
        return 1
    return mystery(n - 1) + mystery(n - 3)

print(mystery(5))
print(mystery(15))