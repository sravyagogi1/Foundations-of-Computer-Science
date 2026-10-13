def every_other(st):
    new_st = ''
    for i in range(len(st)):
        if i % 2 == 0:
            new_st = new_st + st[i]
    return new_st

def count_g(st):
    count = 0
    for ch in st:
        if ch == 'g':
            count += 1
    return count

def encode_letter(letter, code_alpha):
    alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    i = alpha.index(letter)
    return code_alpha[i]

print (encode_letter('X', 'QWERTYUIOPASDFGHJKLZXCVBNM'))