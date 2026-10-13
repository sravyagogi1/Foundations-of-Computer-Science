alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
def vigenere_encode(text, key):
    string = ''
    for i in range(len(text)):
        letter = (alpha.index(text[i]) + (alpha.index(key[i%len(key)]))) % 26
        string += alpha[letter] 
    return string

def vigenere_decode(text, key):
    str = ''
    for i in range(len(text)):
        letter = (alpha.index(text[i]) - (alpha.index(key[i%len(key)]))) % 26
        str += alpha[letter] 
    return str

#print statements
pt = "THEQUICKBROWNFOXJUMPEDOVERTHELAZYDOG"
key = "TEST"
coded = vigenere_encode(pt, key)
decoded = vigenere_decode(coded, key)
print(coded, decoded)

pt = "SPHINXOFBLACKQUARTZJUDGEMYVOW"
key = "KEYWORD"
coded = vigenere_encode(pt, key)
decoded = vigenere_decode(coded, key)
print(coded, decoded) 