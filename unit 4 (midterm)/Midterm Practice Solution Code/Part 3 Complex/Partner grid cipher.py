def fix_string_h(message, width):
    while len(message) % width != 0:
        message += "E"
    return message


def get_column_h(message, width, col):
    return message[col::width]


def grid_encode(message, width):
    message = fix_string_h(message, width)
    encoded = ""
    for i in range(width):
        encoded += get_column_h(message, width, i)
    return encoded

print(grid_encode("THISISANEXAMPLEOFAGRIDCIPHER", 5))