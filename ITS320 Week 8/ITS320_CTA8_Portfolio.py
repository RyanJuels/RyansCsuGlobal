class vehicle:
    def __init__(self, make, model, color,year,mileage):
        self.make = make
        self.model = model
        self.color = color
        self.year = year
        self. mileage = mileage

class automobile:
    def __init__(self):
        self.list_of_vehicles = []

    def add_vehicle(self, make, model, color, year, mileage):
        self.list_of_vehicles.append(vehicle(make, model, color, year, mileage))

    def remove_vehicle(self, make, model, color, year, mileage):
        to_remove = vehicle(make, model, color, year, mileage)
        self.list_of_vehicles.remove(to_remove)

    def to_string(self):
        for i in range(len(self.list_of_vehicles)):
            print(str(i + 1) + ")")
            print("Make:    " + self.list_of_vehicles[i].make)
            print("Model:   " + self.list_of_vehicles[i].model)
            print("Color:   " + self.list_of_vehicles[i].color)
            print("Year:    " + self.list_of_vehicles[i].year)
            print("Mileage: " + self.list_of_vehicles[i].mileage)
            print("\n\n\n")

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
            self.list_of_vehicles[num - 1].make = make
        elif to_update == 2:
            model = input("What is the new model of the car: ")
            self.list_of_vehicles[num - 1].model = model
        elif to_update == 3:
            color = input("What is the new color of the car: ")
            self.list_of_vehicles[num - 1].color = color
        elif to_update == 4:
            year = input("What is the new year of the car: ")
            self.list_of_vehicles[num - 1].year = year
        elif to_update == 5:
            mileage = input("What is the new mileage of the car: ")
            self.list_of_vehicles[num - 1].mileage = mileage
        elif to_update == 6:
            make = input("What is the new make of the car: ")
            model = input("What is the new model of the car: ")
            color = input("What is the new color of the car: ")
            year = input("WHat is the new year of the car: ")
            mileage = input("What is the new mileage of the car: ")
            self.list_of_vehicles[num - 1] = vehicle(make, model, color, year, mileage)