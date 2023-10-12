#-------------------------------------------
# Program Name: Cartesian
# Author: Ryan Juelsgaard
# Date:10 / 12 / 2023
#-------------------------------------------
# Pseudocode:
# Set A list
# Set B list
# call function
# loop through A list {
#   loop through B list {
#       add the formated string with both values of A and B to another List
#   }
# }
# print result list
#-------------------------------------------
# Program Inputs: none
# Program Outputs: List of strings the have ("valueA" x "valueB")
#-------------------------------------------
def cartesian(A, B):
    result = []
    for i in A:
        for j in B:
            result.append("(" + str(i) + ", " + str(j) + ")")
    
    return result


def main():
    A = [1,2]
    B = [3,4]

    print("AxB = ", end='')
    print(cartesian(A, B))


if __name__ == "__main__":
    main()