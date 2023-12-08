#-------------------------------------------
# Program Name: Floating point calculator
# Author: Ryan Juelsgaard
# Date:10 / 12 / 2023
#-------------------------------------------
# Pseudocode: for loop with range 5 {
# float(input(floating point number))
# add to total
# check if number is min or max
# append number with interest to a list 
# }
# print(all needed info)
#-------------------------------------------
# Program Inputs: Floating point number
# Program Outputs: total, average, max, min, and a list of the numbers with interest
#-------------------------------------------
def main():
    nums = []
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
        nums.append(num + num * 0.2)

    print("Total: " + str(total))
    print("Average: " + str(total / 5))
    print("Max: " + str(maximum))
    print("Min: " + str(minimum))
    print(nums)

if __name__ == "__main__":
    main()