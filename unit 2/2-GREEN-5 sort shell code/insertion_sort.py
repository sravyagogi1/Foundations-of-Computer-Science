def insertion_sort(list_arg):
    print("Insertion sort")
    print("Start:", list_arg)
   
    for index in range(1,len(list_arg)):
        temp = list_arg[index]#the current index
        value = index - 1 #one position ahead
       
        # compare value with every elemnt in the list until smaller is found
        while value >= 0 and temp < list_arg[value]:
        #is the value greater than 0 and smaller than the first element of the array?
            list_arg[value + 1] = list_arg[value]
            value -= 1
            # if both are true then move the first element to the first index and reduce j
        list_arg[value + 1] = temp #go to the next pass
    
        print("Insertion" + str(index) + ":" , list_arg)
    print()

def printtest():
    test_list = [15, 4, 11, 9, 7, 5, 10, 13, 17, 2]
    insertion_sort(test_list)
printtest()