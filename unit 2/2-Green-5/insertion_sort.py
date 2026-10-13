def insertion_sort(list_arg):
    print("Insertion sort")
    print("Start:", list_arg)
   
    for index in range(1,len(list_arg)):
        temp = list_arg[index]
        value = index - 1 
       
        while value >= 0 and temp < list_arg[value]:
            list_arg[value + 1] = list_arg[value]
            value -= 1  
        list_arg[value + 1] = temp 
    
        print("Insertion" + str(index) + ":" , list_arg)
    print()

def printtest():
    test_list = [15, 4, 11, 9, 7, 5, 10, 13, 17, 2]
    insertion_sort(test_list)
printtest()