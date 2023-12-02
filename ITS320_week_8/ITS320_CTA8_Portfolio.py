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
        retval = ""
        retval += "    Make:    " + self.make + "\n"
        retval += "   Model:   " + self.model + "\n"
        retval += "   Color:   " + self.color + "\n"
        retval += "   Year:    " + self.year + "\n"
        retval += "   Mileage: " + self.mileage + "\n\n"

        return retval

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

    def remove_vehicle(self):
        if len(self.list_of_vehicles) == 0:
            print("There are no vehocles in the inventory to remove")
        else:
            print(self.to_string())
            choice = 0
            while choice < 1 or choice > len(self.list_of_vehicles):
                try:
                    choice = int(input("What vehicle would you like to remove: "))
                except ValueError:
                    print("Didn't enter a valid number")
            self.list_of_vehicles.remove(self.list_of_vehicles[choice - 1])

    def to_string(self):
        retval = ""
        for i in range(len(self.list_of_vehicles)):
            retval += str(i + 1) + ")\n" 
            retval += self.list_of_vehicles[i].print_vehicle()
        
        return retval
    
    def export_to_file(self):
        sourceFile = open('inventory.txt', 'w')
        print(self.to_string(), file = sourceFile)
        sourceFile.close()

    def update_vehicle(self):
        if len(self.list_of_vehicles) == 0:
            print("There are no vehocles in the inventory to update")
        else:
            num = 0
            print(self.to_string())
            while num < 1 or num > len(self.list_of_vehicles):
                try:
                    num = int(input("What car would you like to update (enter number of car): "))
                except ValueError:
                    print("Didn't enter a valid number")

            print("1) Make")
            print("2) Model")
            print("3) Color")
            print("4) Year")
            print("5) Mileage")
            print("6) Whole Car")
            to_update = 0
            while to_update < 1 or to_update > 6:
                try:
                    to_update = int(input("Which would you like to update: "))
                except ValueError:
                    print("Didn't enter a valid number")
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
    inventory = vehicle_inventory()
    choice = ''
    print("Welcome!\n")
    while choice != '6':
        choice = ''
        print("\n1) View vehicles")
        print("2) Add Vehicle")
        print("3) Remove vehicle")
        print("4) Update vehicle")
        print("5) Export to file")
        print("6) Exit program\n")
        choice = input("What would you like to do?: ")
        if choice == '1':
            print(inventory.to_string())
        elif choice == '2':
            inventory.add_vehicle()
        elif choice == '3':
            inventory.remove_vehicle()
        elif choice == '4':
            inventory.update_vehicle()
        elif choice == '5':
            inventory.export_to_file()




if __name__ == "__main__":
    main()