#include<iostream>

using namespace std;

int main() {
    string s1;
    string s2;
    for(int i = 0; i < 3; i++){
        cout << "Enter first string: ";
        getline(cin, s1);
        
        cout << "Enter second string: ";
        getline(cin, s2);

        cout << "Your concatenated string: " << s1 + s2 << endl;
    }
    return 0;
}