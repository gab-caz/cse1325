#include <iostream>
#include <stdexcept>
#include <string>
#include "clock.h"
#include "timer.h"

int main(int argc, char** argv)
{
    if(argc != 4)
    {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        return -1;
    }

    Timer newTimer(0,0,0);

    try
    {
        int hours = std::stoi(argv[1]);
        int minutes = std::stoi(argv[2]);
        int seconds =  std::stoi(argv[3]);

        newTimer = Timer(hours, minutes, seconds);
    }
    catch(std::out_of_range e)
    {
        std::cerr << "Exception: " << e.what() << std::endl;
        return -2;
    }

    std::cout << "\n\nEnter 'q' to quit.\n\n";

    while(true)
    {
        std::cout << "Remaining time is now ";
        newTimer.print();
        
        std::string input;
        std::getline(std::cin, input);

        if(input == "q")
        {
            return 0;
        }
        else
        {
            try
            {
                newTimer.tic();
            }
            catch(std::runtime_error e)
            {
                std::cout << "Timer expired " << e.what() << std::endl;
            }
        }
    }

    return 0;
}