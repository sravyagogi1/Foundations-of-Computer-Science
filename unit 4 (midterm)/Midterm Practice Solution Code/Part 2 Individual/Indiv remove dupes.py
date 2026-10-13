def remove_dupes(ls):
    return_ls = []
    for val in ls:
        if val not in return_ls:
            return_ls.append(val)
    return return_ls

print(remove_dupes([1, 2, 5, 1, 4, 3, 1, 2, 11, 5, 3, 2]))