def division(dividend, divisor):
    result = 0
    while dividend >= divisor:
        dividend -= divisor
        result += 1
    return result


def binary_convert(ls):
    string = ""
    for i in range(len(ls)):
        if ls[i] == True:
            string += "1"
        else:
            string += "0"
    return string

def multiple_sum(num1, num2, maximum):
    sum = 0
    count = 0
    while count <= maximum:
        if count % num1 == 0 or count % num2 == 0:
            sum += count
        count += 1
    return sum

def jump_sequence_max(n):
    sequence = [n]
    while n > 1:
        if n % 2 == 0:
            n = n // 2
        else:
            n = (3 * n) + 1
        sequence.append(n)
        
    return max(sequence)

def most_common_count(st):
    max = 0
    for i in range(len(st)):
        if st.count(st[i]) > max:
            max = st.count(st[i])
    return max


def copy_wihtout_dupes(ls):
    result = []
    for i in range(len(ls)):
        if result.count(ls[i]) == 0:
            result.append(ls[i])
    return result