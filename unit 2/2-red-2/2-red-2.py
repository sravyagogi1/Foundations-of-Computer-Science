dict = {'A':10, 'B':11, 'C':12, 'D':13, 'E':14, 'F':15}

def dictionary(item):
    for key, value in dict.items():
        if item == value:
            return key

def convert_to_base(number, from_base, to_base):
    if (2 > from_base) or  (from_base > 16) or (2 > to_base) or (to_base >16):
        print("Please choose a base from 2-16")
        return
    
    base_10 = 0
    for i in range(len(number)):
        value = int(number[-i-1], from_base)
        base_10 += value * (from_base ** i)

    result = ''
    while base_10 > 0:
        remainder = base_10 % to_base
        if remainder >= 10:
            result = dictionary(remainder) + result
        else:
            result = str(remainder) + result
        base_10 //= to_base
    return result

number = input("Convert this number: ")
from_base = int(input("From this base: "))
to_base = int(input("To this base: "))

result = convert_to_base(number, from_base, to_base)
print(f"Answer: {result}")