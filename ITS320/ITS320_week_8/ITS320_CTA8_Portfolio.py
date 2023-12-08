class vehicle:
    def __init__(self, make, model, color,year,mileage):
        self.make = make
        self.model = model
        self.color = color
        self.year = year
        self. mileage = mileage

    def get_make(self):
        return self.make

    def print_vehicle(self):
        print("    Make:    " + self.make + "\n")
        print("   Model:   " + self.model + "\n")
        print("   Color:   " + self.color + "\n")
        print("   Year:    " + self.year + "\n")
        print("   Mileage: " + self.mileage + "\n\n")

class vehicle_inventory:
    def __init__(self):
        self.list_of_vehicles = []

    def add_vehicle(self):
        make = input("What is the make of the car: ")
        model = input("What is the model of the car: ")
        color = input("What is the color of the car: ")
        year = input("WHat is the year of the car: ")
        mileage = input("What is the mileage of the car: ")
        self.list_of_vehicles.append(vehicle(make, model, color, year, mileage))

    def remove_vehicle(self, make, model, color, year, mileage):
        self.to_string()
        num = int(input("What car would you like to remove (enter number of car): "))
        while num < 1 and num > len(self.list_of_vehicles):
            num = input("Please enter a valid car you would like to remove (enter number of car): ")
        self.list_of_vehicles.remove(self.list_of_vehicles[num - 1])

    def to_string(self):
        for i in range(len(self.list_of_vehicles)):
            print(str(i + 1) + ")")
            self.list_of_vehicles[i].print_vehicle

    def update_vehicle(self):
        self.to_string()
        num = int(input("What car would you like to update (enter number of car): "))
        while num < 1 and num > len(self.list_of_vehicles):
            num = input("Please enter a valid car you would like to update (enter number of car): ")

        print("1) Make")
        print("2) Model")
        print("3) Color")
        print("4) Year")
        print("5) Mileage")
        print("6) Whole Car")
        to_update = input("Which would you like to update: ")
        while(to_update < 1 or to_update > 6):
            input("Pleas choose a valid attribute to update: ")
        if to_update == 1:
            make = input("What is the new make of the car: ")
            self.list_of_vehicles[num - 1].set_make(make)
        elif to_update == 2:
            model = input("What is the new model of the car: ")
            self.list_of_vehicles[num - 1].set_model(model)
        elif to_update == 3:
            color = input("What is the new color of the car: ")
            self.list_of_vehicles[num - 1].set_color(color)
        elif to_update == 4:
            year = input("What is the new year of the car: ")
            self.list_of_vehicles[num - 1].set_year(year)
        elif to_update == 5:
            mileage = input("What is the new mileage of the car: ")
            self.list_of_vehicles[num - 1].set_mileage(mileage)
        elif to_update == 6:
            make = input("What is the new make of the car: ")
            model = input("What is the new model of the car: ")
            color = input("What is the new color of the car: ")
            year = input("WHat is the new year of the car: ")
            mileage = input("What is the new mileage of the car: ")
            self.list_of_vehicles[num - 1] = vehicle(make, model, color, year, mileage)



def main():
    inventory = car_inventory()
    choice = 0
    while choice < 1 or choice > 4
        try:
            choice = int(input("Welcome! What would you like to do?\n\n1) View vehicle\n2) Add Vehicle\n3) Remove vehicle\n4) Update vehicle\n\n"))
        except ValueError:
            print("Didn't enter a valid number")
