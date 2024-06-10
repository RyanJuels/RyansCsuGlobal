#include <iostream>
#include <limits>
using namespace std;

int main()
{

    int i1, i2, i3;
    int *p_i1, *p_i2, *p_i3;

    while(1) {
        cout << "Enter number 1: " ;
        if (cin >> i1) {
            break;
        }
        else {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        }
    }
    
    while(1) {
        cout << "Enter number 2: " ;
        if (cin >> i2) {
            break;
        }
        else {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        }
    }

    while(1) {
        cout << "Enter number 3: " ;
        if (cin >> i3) {
            break;
        }
        else {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        }
    }

    p_i1 = new int(i1);
    p_i2 = new int(i2);
    p_i3 = new int(i3);

    cout << "num 1: " << i1 << ", p_num 1: " << *p_i1 << endl;
    cout << "num 2: " << i2 << ", p_num 2: " << *p_i2 << endl;
    cout << "num 3: " << i3 << ", p_num 3: " << *p_i3 << endl;

    delete p_i1;
    delete p_i2;
    delete p_i3;

   return 0;
}