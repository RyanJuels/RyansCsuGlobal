def main():
    total = 0

    for i in range(5):
        num = float(input("Please enter a floating point number: "))
        total += num
        if i == 0:
            minimum = num
            maximum = num
        elif num > maximum:
            maximum = num
        elif num < minimum:
            minimum = num

    print("Average: " + str(total / 5))
    print("Max: " + str(maximum))
    print("Min: " + str(minimum))

if __name__ == "__main__":
    main()