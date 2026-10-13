def synth_alg(coeff, root):
    result = [coeff[0]]
    for i in range(1, len(coeff)):
        result.append(result[-1] * root + coeff[i])
    return result[:-1]

def result_string(coeff):
    if len(coeff) - 1 > 2:
        final_str = str(coeff[0]) + "x^" + str(len(coeff) - 1)
    else:
        final_str = str(coeff[0]) + "x"

    for i in range(1, len(coeff)):
        if (len(coeff) - i - 1) < 1:
            final_str = final_str + "+" + str(coeff[i])
        elif (len(coeff) - i - 1) < 2:
            final_str = final_str + " + " + str(coeff[i]) + "x"
        else:
            final_str = final_str + " + " + str(coeff[i]) + "x^" + str(len(coeff) - i - 1)

    return final_str


test = [2, 11, 15]
root = -3
print(result_string(synth_alg(test, root)))

test = [1, -3, 5, -17, 6]
root = 3
print(result_string(synth_alg(test, root)))
