#AAAA
def three_letter_words(s):
    words = []
    current_word = ""

    for char in s:
        if char.isalpha():
            current_word += char
        elif current_word and len(current_word) == 3:
            words.append(current_word)
            current_word = ""
        else:
            current_word = ""

    if current_word and len(current_word) == 3:
        words.append(current_word)

    return words

print(three_letter_words("The, and! Unfortunately Not. "))
print(three_letter_words("Hello my nam is cat and I love dog."))

#BBB
def vowel_consume(s):
    result = list(s)

    for i, char in enumerate(s):
        if char in "aeiouAEIOU":
            if i > 0 and result[i - 1] not in "aeiouAEIOU":
                result[i - 1] = char
            if i < len(s) - 1 and result[i + 1] not in "aeiouAEIOU":
                result[i + 1] = char

    return ''.join(result)

print(vowel_consume("xxix"))
print(vowel_consume("example"))
print(vowel_consume("deleterious"))
print(vowel_consume("strength"))

#CCC
def filter_string(a, b):
    result = ''
    for char in a:
        if char in b:
            result += char
    result += '*'
    for char in a:
        if char not in b:
            result += char
    return result

print(filter_string("abcdefghij", "filter"))
print(filter_string("strength", "the"))
print(filter_string("whatever", ""))   

#DDD
def alternate_forbid(a, b, x):
    result = ""
    min_len = min(len(a), len(b))

    for i in range(min_len):
        if i % 2 == 0:
            if a[i] in x:
                result += b[i] if b[i] not in x else "!"
            else:
                result += a[i]
        else:
            if b[i] in x:
                result += a[i] if a[i] not in x else "!"
            else:
                result += b[i]

    return result

print(alternate_forbid("aaa", "bbb", ""))
print(alternate_forbid("aaa", "bbb", "b"))
print(alternate_forbid("abcde", "xxxx", "cd"))
print(alternate_forbid("abcde", "xxxx", "cx"))

def alternate_forbid(a, b, x):
    result = ""
    min_len = min(len(a), len(b))

    for i in range(min_len):
        if i % 2 == 0:
            if a[i] in x:
                result += b[i] if b[i] not in x else "!"
            else:
                result += a[i]
        else:
            if b[i] in x:
                result += a[i] if a[i] not in x else "!"
            else:
                result += b[i]

    return result
