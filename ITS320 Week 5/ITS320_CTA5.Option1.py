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