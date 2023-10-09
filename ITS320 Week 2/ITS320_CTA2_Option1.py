def main():
    has_alphanum = False
    has_alpha = False
    has_num = False
    has_lower = False
    has_upper = False
    S = ""

    while(0 == len(S) or len(S) > 50): 
        S = input("Please input your string less than 50 characters: ")

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