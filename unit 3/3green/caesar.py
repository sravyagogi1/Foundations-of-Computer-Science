def caesar_crack(text):
    best_text = ''
    letters = 0
    for i in range(1,26):
        letters += text.count('E')
        letters += text.count('A')
        letters += text.count('T')
        letters += text.count('a')
        letters += text.count('e')
        letters += text.count('t')
    return letters

def encode_letter(letter, code_alpha):
    alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    i = alpha.index(letter)
    return code_alpha[i]

print (encode_letter('X', 'QWERTYUIOPASDFGHJKLZXCVBNM'))

