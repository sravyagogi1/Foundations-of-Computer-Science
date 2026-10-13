def insert_every_two(s1, s2):
    result = ""
    i = 0
    while i < len(s1):
        result += s1[i:i+2]
        if i + 2 < len(s1):  # Check if there are more characters in s1
            result += s2
        i += 2   
    return result

#print(insert_every_two("abcdef", "xx"))  # Output: "abxxcdxxef"
#print(insert_every_two("12345", "---"))

def substitution_encode(text, code_alpha):
    alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    encoded_text = ''

    for letter in text:
        if letter.upper() in alpha:
            original_case = letter.isupper()
            i = alpha.index(letter.upper())
            encoded_letter = code_alpha[i]
            encoded_text += encoded_letter.upper() if original_case else encoded_letter.lower()
        else:
            # If the character is not a letter, keep it unchanged
            encoded_text += letter

    return encoded_text

def substitution_decode (encoded_text, code_alpha):
    alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'
    decoded_text = ''

    for encoded_letter in encoded_text:
        if encoded_letter.upper() in code_alpha:
            original_case = encoded_letter.isupper()
            i = code_alpha.index(encoded_letter.upper())
            decoded_letter = alpha[i]
            decoded_text += decoded_letter.upper() if original_case else decoded_letter.lower()
        else:
            # If the character is not in the decoding alphabet, keep it unchanged
            decoded_text += encoded_letter

    return decoded_text

pt = "'Don't stop believin'!' - Journey, 1981"
a2 = "GWCHBUFINAMKZTOELPSJYROVXD"
enc = substitution_encode (pt, a2)
dec = substitution_decode(enc, a2)
print (enc)
print (dec)