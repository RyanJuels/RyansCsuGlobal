#-------------------------------------------
# Program Name: Grade Calculator
# Author: Ryan Juelsgaard
# Date:10 / 12 / 2023
#-------------------------------------------
# Pseudocode: for loop with range 5 {
# float(input(floating point number))
# add to total
# check if number is min or max
#}
# print(all needed info)
#-------------------------------------------
# Program Inputs: Floating point number
# Program Outputs: Average, max, min
#-------------------------------------------
def main():
    total = 0

    for i in range(5):
        num = int(input("Please enter your grade: "))
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