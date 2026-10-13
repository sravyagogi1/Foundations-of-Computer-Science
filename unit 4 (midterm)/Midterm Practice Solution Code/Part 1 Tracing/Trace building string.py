def mystery(st):
    temp = st
    counter = 0
    while len(temp) > 0:
        temp = temp[1:-1]
        if counter % 2 == 0:
            for i in range(len(temp) - 1, -1, -1):
                st += temp[i]
        else:
            st += temp
        counter += 1
    return st

print(mystery("ABCDE"))
print(mystery("FOUNDATIONS"))