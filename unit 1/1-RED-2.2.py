def TF_1_3(n):
    if n % 10 == 1 or n % 10 == 3:
        return True
    else:
        return False
def sum_ends_1_or_3(n):
    if n == 0:
        return 0
    elif TF_1_3(n):
        recursive_result = sum_ends_1_or_3(n-1)
        print(n, "ends with 1 or 3.")
        return n + recursive_result
    elif not TF_1_3(n):
        return sum_ends_1_or_3(n - 1)   
def print_sum_ends_1_or_3_results(n):
    answer = sum_ends_1_or_3(n)
    print("The final sum is:", answer)
print(print_sum_ends_1_or_3_results(20))


def print_bouncy_sum(a):
    if a < 100 or a > 999:
        return False
    elif a // 100 < ((a % 100) // 10) > a % 10:
        return True
    else:
        return False
def bouncy(a,b):
    if a == b+1:
        return 0
    elif print_bouncy_sum(a)== True:
        print(a, "is bouncy")
        return a + bouncy(a+1,b)
    elif print_bouncy_sum(a)== False:
        return bouncy(a + 1,b)   
def print_bouncy_results(a):
    answer = bouncy(a)
    print("The final sum is:", answer)
#print(bouncy(200,250))