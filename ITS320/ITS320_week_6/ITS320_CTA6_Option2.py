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
    A = []
    B = []
    userInput = ''
    while userInput != -1:
        userInput  = int(input("Please enter what you want in the first array (enter -1 tomove on): "))
        if userInput != -1:
            A.append(userInput)

    while userInput != -1:
        userInput  = int(input("Please enter what you want in the second array (enter -1 tomove on): "))
        if userInput != -1:
            B.append(userInput)
    print(cartesian(A, B))


if __name__ == "__main__":
    main()