#include <iostream>
#include <stdexcept>
#include <string>
#include "clock.h"

int main(int argc, char** argv)
{
    if(argc != 4)
    {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        return -1;
    }

    Clock newClock(0,0,0);

    try
    {
        int hours = std::stoi(argv[1]);
        int minutes = std::stoi(argv[2]);
        int seconds =  std::stoi(argv[3]);

        newClock = Clock(hours, minutes, seconds);
    }
    catch(std::out_of_range e)
    {
        std::cerr << "Exception: " << e.what() << std::endl;
        return -2;
    }

    while(true)
    {
        newClock.print();

        std::cout << "Enter 'q' to quit.";
        std::string input;
        std::getline(std::cin, input);

        if(input == "q")
        {
            return 0;
        }
        else
        {
            newClock.tic();
        }
    }

    return 0;
}