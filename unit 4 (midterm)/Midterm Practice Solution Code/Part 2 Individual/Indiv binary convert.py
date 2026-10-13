def binary_convert(ls):
    ret_st = ""
    for val in ls:
        if val == True:
            ret_st += "1"
        else:
            ret_st += "0"
    return ret_st

print(binary_convert([True, True, False, True, False]))