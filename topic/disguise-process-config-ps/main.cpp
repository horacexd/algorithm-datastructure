/*
    reference: https://www.zhihu.com/question/27518530
*/

#include <iostream>
#include <chrono>
#include <thread>

using namespace std;

int main(int argc, char** argv) {

    if (argc <= 1) {
        cout << "Fail usage: less arguments" << endl;
        return -1;
    }

    if (argc > 2) {
        cout << "Fail usage: too many arguments" << endl;
        return -1;
    }

    for (int i = 0; argv[1][i]; i++) {
        argv[1][i] = 'x';
    }

    while (true) {
        this_thread::sleep_for(chrono::milliseconds(1000));
        cout << "Hello world!" << endl;
    }
    return 0;
}