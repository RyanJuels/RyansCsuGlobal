#include<iostream>
#include<thread>
#include<mutex>

using namespace std;

int g_count = 0;
mutex count_mutex;

void increase_count() {
    count_mutex.lock();
    cout << endl << "Starting count up to 20" << endl;
    while(g_count < 20) {
        g_count++;
        cout << "Increasing count to: " << g_count << endl;
    }
    count_mutex.unlock();
}

void decrease_count() {
    count_mutex.lock();
    cout << endl << "Starting count down to 0" << endl;
    while(g_count > 0) {
        g_count--;
        cout << "Decreasing count to: " << g_count << endl;
    }
    count_mutex.unlock();
}

int main() {
    
    thread t1(increase_count);
    thread t2(decrease_count);

    t1.join();
    t2.join();


    return 0;
}