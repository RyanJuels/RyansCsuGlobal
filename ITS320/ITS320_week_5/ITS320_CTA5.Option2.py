#-------------------------------------------
# Program Name: Reverse Third String
# Author: Ryan Juelsgaard
# Date:10 / 12 / 2023
#-------------------------------------------
# Pseudocode:
# loop 3 times {
# input(string to be added)
# append string to list
# }
# call function
# loop through list in reverse {
# first and second time add string to result string
# third time print result string
# print last string in reverse
# }
#-------------------------------------------
# Program Inputs: Strings
# Program Outputs: Strings in reverse order of given
#-------------------------------------------
def reverse_strings(S):
    result = ''
    for i in range(len(S)):
        if (i != len(S) - 1):
            result += S[i]
        else:
            result += ("\n")
            result += (S[i] [::-1])
    return result


def main():
    strings = []
    for i in range(3):
        strings.append(input("Please enter string #" + str(i + 1) + ": "))

    print(reverse_strings(strings))

if __name__ == "__main__":
    main()