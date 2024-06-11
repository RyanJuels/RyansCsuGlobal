#include<iostream>
#include<fstream>
using namespace std;

int main() {
    fstream myfile;
    myfile.open("CSC450_CT5_mod5.txt", ios::app);

    string user_input;

    cout << "String to add to file: ";
    getline(cin, user_input);

    myfile << endl << user_input << endl;

    myfile.close();


    ifstream original_file;
    original_file.open("CSC450_CT5_mod5.txt");

    string all_file, line;
    while(getline(original_file, line)) {
        all_file += line;
        all_file += '\n';
    }

    ofstream reverse_file;
    reverse_file.open("CSC450-mod5-reverse.txt");
    
    for(int i = all_file.length() - 1; i >= 0; i--) {
        
        reverse_file << all_file.at(i);
    }

    reverse_file.close();
    original_file.close();
    
}