def swap(list_arg, index1, index2):
    temp = list_arg[index1]
    list_arg[index1] = list_arg[index2]
    list_arg[index2] = temp

def find_min_index(list_arg, start):
    min = start # sets the minimun to index 0
    for i in range(start, len(list_arg)): 
        if list_arg[i] < list_arg[min]: # compares the values to each other to find the smallest value
            min = i # setting the new value to an index
    return min #returning new mininum

def selection_sort(list_arg):
    print("Selection sort")
    print("Start:", list_arg)
    for i in range(len(list_arg)-1):
        next_min = find_min_index(list_arg, i)
        swap(list_arg, i, next_min)
        print("Selection swap " + str(i) + ":", list_arg)
    print()


test_list = [15, 4, 11, 9, 7, 5, 10, 13, 17, 2]
selection_sort(test_list)