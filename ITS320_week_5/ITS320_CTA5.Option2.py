def reverse_strings(S):
    result = ''
    for i in range(len(S)):
        if (i == 0 or i == 1):
            result += S[i]
        else:
            print(result)
            print(S[i] [::-1])
    return result


def main():
    strings = []
    for i in range(3):
        strings.append(input("Please enter string #" + str(i + 1) + ": "))

    reverse_strings(strings)

if __name__ == "__main__":
    main()