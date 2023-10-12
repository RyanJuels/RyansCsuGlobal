#-------------------------------------------
# Program Name: String details
# Author: Ryan Juelsgaard
# Date: 10 / 12 / 2023
#-------------------------------------------
# Pseudocode: 
# input(User input)
# if(input out of what we want){ask again}
# for(char in string){ test each character for if they are one of what we need}
# if(char is what we need) { set appropriate bool to true}
# print(bools)
#-------------------------------------------
# Program Inputs: any string less than 50 characters
# Program Outputs: multiple true or false values if the string has any of the correct characters in them
#-------------------------------------------

def main():
    has_alphanum = False
    has_alpha = False
    has_num = False
    has_lower = False
    has_upper = False

    S = input("Please input your string less than 50 characters: ")
    while(0 == len(S) or len(S) > 50): 
        S = input("Please input your string less than 50 characters: ")

    # Assignment said the the string contains any of the appropriate characters
    # So we loop through the string to find out
    for c in S:
        if(str.isalnum(c)):
            has_alphanum = True
        if(str.isalpha(c)):
            has_alpha = True
        if(str.isdigit(c)):
            has_num = True
        if(str.islower(c)):
            has_lower = True
        if(str.isupper(c)):
            has_upper = True

    print("Has alphanumeric characters: " + str(has_alphanum))
    print("Has alphabetical characters: " + str(has_alpha))
    print("Has digit characters:        " + str(has_num))
    print("Has lowercade characters:    " + str(has_lower))
    print("Has uppercase characters:    " + str(has_upper))

if __name__ == "__main__":
    main()