def most_common_count(st):
    best_count = 0
    for ch in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
        temp = st.count(ch)
        if temp > best_count:
            best_count = temp
    return best_count

print(most_common_count("AAAAAABB"))