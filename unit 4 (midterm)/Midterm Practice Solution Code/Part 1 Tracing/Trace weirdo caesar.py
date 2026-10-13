def mystery(st, n, s):
    alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    final = ""
    for i in range(len(st)):
        if i % n == 0:
            temp = alpha.index(st[i])
            temp += s
            temp %= 26
            final += alpha[temp]
        else:
            final += st[i]
    return final

temp = mystery("QESQIND", 3, 3)
print(temp)

temp = mystery("OHIFVVFRRM", 3, 5)
temp = mystery(temp, 1, 7)
temp = mystery(temp, 2, 2)
print(temp)



# temp = mystery("CORRECTYAY", 2, 24)
# temp = mystery(temp, 1, 19)
# temp = mystery(temp, 3, 21)
# print(temp)
# temp = mystery(temp, 3, 5)
# temp = mystery(temp, 1, 7)
# temp = mystery(temp, 2, 2)
# print(temp)
#
# temp = mystery("TESTING", 3, 23)
# print(temp)