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

        make = input("What is the new make of the car: ")
        model = input("What is the new model of the car: ")
        color = input("What is the new color of the car: ")
        year = input("WHat is the new year of the car: ")
        mileage = input("What is the new mileage of the car: ")

        self.list_of_vehicles[num - 1] = vehicle(make, model, color, year, mileage)