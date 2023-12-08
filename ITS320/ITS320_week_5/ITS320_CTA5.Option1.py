#-------------------------------------------
# Program Name: Reverse Strings List
# Author: Ryan Juelsgaard
# Date:10 / 12 / 2023
#-------------------------------------------
# Pseudocode:
# loop 3 times {
# input(string to be added)
# append string to list
# }
# call function
# loop through list in reverse{
# add item in list to result string
# }
# print result string
#-------------------------------------------
# Program Inputs: Strings
# Program Outputs: Strings in reverse order of given
#-------------------------------------------
def reverse_strings(S):
    result = ''
    for i in reversed(S):
        result += i
    return result


def main():
    strings = []
    for i in range(3):
        strings.append(input("Please enter string #" + str(i + 1) + ": "))

    print(reverse_strings(strings))

if __name__ == "__main__":
    main()