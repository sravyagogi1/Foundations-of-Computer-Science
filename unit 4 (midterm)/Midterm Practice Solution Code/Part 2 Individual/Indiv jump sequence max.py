def next_step(n):
    if n % 2 == 0:
        return n // 2
    return n * 3 + 1

def jump_sequence_max(n):
    biggest = n
    while n != 1:
        n = next_step(n)
        if n > biggest:
            biggest = n
    return biggest

print(jump_sequence_max(13))