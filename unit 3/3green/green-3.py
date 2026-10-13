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

pt = "'The greatest films of all time were never made' - Taylor Swift, 2020"
shift = 10
enc = caesar_encode(pt, shift)
dec = caesar_decode(enc, shift)
print(enc)
print(dec)