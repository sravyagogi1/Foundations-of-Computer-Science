def binary_to_integer(bin_str):
    value = 0
    for i in range(len(bin_str)):
        value += int(bin_str[-i-1]) * (2 ** i)
    return value

#print(binary_to_integer('110'))


def integer_to_binary(bin_str):
    binary = []
    bin_str = int(bin_str)

    while bin_str > 0:
        if bin_str % 2 == 0:
            binary.insert(0,'0')
        if bin_str % 2 == 1:
            binary.insert(0,'1')
        bin_str //= 2
    binary_num = ''.join(binary)
    return binary_num

#print(integer_to_binary('5'))
#print(integer_to_binary('255'))
#print(integer_to_binary('342'))

def convert_to_base(number, from_base, to_base):
    if (2 > from_base) or  (from_base > 16) or (2 > to_base) or (to_base >16):
        print("Please choose a base from 2-16")
        return
    
    base_10 = 0
    for i in range(len(number)):
        value = int(number[-i-1], from_base)
        base_10 += value * (from_base ** i)

    result = ""
    while base_10 > 0:
        remainder = base_10 % to_base
        result = str(remainder) + result
        base_10 //= to_base
    return result


number = input("Convert this number: ")
from_base = int(input("From this base: "))
to_base = int(input("To this base: "))

result = convert_to_base(number, from_base, to_base)
print(f"Answer: {result}")