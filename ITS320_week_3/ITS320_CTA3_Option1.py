#-------------------------------------------
# Program Name: Car Price per Year
# Author: Ryan Juelsgaard  
# Date: 10 / 12 / 2023
#-------------------------------------------
# Pseudocode: 
#
# input(year of car)
# if (not valid year) {ask again for a valid year }
# if statment with elif (car year matches){ print price}
#-------------------------------------------
# Program Inputs: Year of car
# Program Outputs: Price of Car at given year
#-------------------------------------------

def main(): 
    year = input("What year is the car: ")
    while(year < '1962' or year > '2014'):
        year = input("please enter a valid year for the car: ")
    if(year >= '1962' and year <= '1964'):
        print('$18,500')
    elif(year >= '1965' and year <= '1968'):
        print('$6,000')
    elif(year <= '1971'):
        print('$12,000')
    elif(year <= '1975'):
        print('$48,000')
    elif(year <= '1980'):
        print('$200,000')
    elif(year <= '1985'):
        print('$650,000')
    elif(year <= '2012'):
        print('$35,000,000')
    elif(year >= '2013' and year <= '2014'):
        print('$52,000,000')

if __name__ == "__main__":
    main()