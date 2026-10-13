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

def caesar_crack(string):
    best_string = ''
    best_score = 0

    for shift in range(1, 26):
        decoded = caesar_decode(string, shift)
        score = decoded.lower().count('e') + decoded.lower().count('t') + decoded.lower().count('a')

        if score > best_score:
            best_score = score
            best_string = decoded

    return best_string

enc1 = """'M wex hsar erh avsxi xli jmvwx gsqtmpiv. Mx aew zivc wxytmh. Alex M hmh aew
aexgl qcwipj tyx xskixliv e tvskveq erh qeoi xli gsqtyxiv hs alex M hmh.' - Kvegi
Lsttiv, gsqtyxiv wgmirxmwx erh qmpmxevc ehqmvep"""
enc2 = """'Pgpcjmzoj dszfwo wplcy ez aczrclx l nzxafepc, mpnlfdp te eplnspd jzf szh ez
estyv.' - Depgp Uzmd, qzcxpc NPZ lyo ncplezc zq Laawp"""
enc3 = """'Max Bgmxkgxm? Px tkx ghm bgmxkxlmxw bg bm.' - Ubee Ztmxl, yhngwxk hy Fbvkhlhym,
1993"""

print(caesar_crack(enc1))
print(caesar_crack(enc2))
print(caesar_crack(enc3))