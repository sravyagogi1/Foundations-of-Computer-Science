def substitution_encode(text, code_alpha):
    alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    encoded_text = ''

    for letter in text:
        if letter.upper() in alpha:
            i = alpha.index(letter.upper())
            if letter.islower():
                encoded_text += code_alpha[i].lower()
            else:
                encoded_text += code_alpha[i]
        else:
            encoded_text += letter

    return encoded_text

def substitution_decode(text, code_alpha):
    alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    decoded_text = ''

    for letter in text:
        if letter.upper() in alpha:
            i = code_alpha.index(letter.upper())
            if letter.islower():
                decoded_text += alpha[i].lower()
            else:
                decoded_text += alpha[i]
        else:
            decoded_text += letter

    return decoded_text

def caesar_encode(text, shift):
    alpha_upper = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    alpha_lower = 'abcdefghijklmnopqrstuvwxyz'
    encoded_text = ''

    for letter in text:
        if letter.isupper():
            encoded_text += alpha_upper[(alpha_upper.index(letter) + shift) % 26]
        elif letter.islower():
            encoded_text += alpha_lower[(alpha_lower.index(letter) + shift) % 26]
        else:
            encoded_text += letter

    return encoded_text

def caesar_decode(text, shift):
    alpha_upper = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    alpha_lower = 'abcdefghijklmnopqrstuvwxyz'
    decoded_text = ''

    for letter in text:
        if letter.isupper():
            decoded_text += alpha_upper[(alpha_upper.index(letter) - shift) % 26]
        elif letter.islower():
            decoded_text += alpha_lower[(alpha_lower.index(letter) - shift) % 26]
        else:
            decoded_text += letter

    return decoded_text


#print statements
pt = "'Don't stop believin'!' - Journey, 1981"
a2 = "GWCHBUFINAMKZTOELPSJYROVXD"
enc = substitution_encode (pt, a2)
dec = substitution_decode(enc, a2)
print (enc)
print (dec)
pt = "'The greatest films of all time were never made' - Taylor Swift, 2020"
shift = 10
enc = caesar_encode (pt, shift)
dec = caesar_decode (enc, shift)
print (enc)
print (dec)