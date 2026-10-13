def mystery(ls):
    for count in range(len(ls)//2):
        i = 0
        rising = True
        while i != -1:
            if ls[i] > ls[i+1]:
                temp = ls[i+1]
                ls[i+1] = ls[i]
                ls[i] = temp
            if i == len(ls) - 2:
                rising = False
                i -= 1
            elif rising == True:
                i += 1
            else:
                i -= 1
        print(ls)

mystery([17, 11, 4, 8])
print()
mystery([10, 9, 8, 7, 6, 5, 4, 3, 2, 1])