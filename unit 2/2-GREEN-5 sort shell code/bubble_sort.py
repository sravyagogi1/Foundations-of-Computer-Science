def swap(list_arg, index1, index2):
    temp = list_arg[index1]
    list_arg[index1] = list_arg[index2]
    list_arg[index2] = temp

def do_a_bubble_pass(list_arg):
    for i in range(len(list_arg) - 1):  # Why is there a -1 here? Because there is nothing to compare the last index to
        if list_arg[i] > list_arg[i+1]:
            swap(list_arg, i, i+1)

def bubble_sort(list_arg):
    print("Bubble sort")
    print("Start:", list_arg)
    for i in range(len(list_arg) - 1):  # Why is there a -1 here? 
        do_a_bubble_pass(list_arg)
        print("Bubble pass " + str(i) + ":", list_arg)
    print()

test_list = [15, 4, 11, 9, 7, 5, 10, 13, 17, 2]
bubble_sort(test_list)