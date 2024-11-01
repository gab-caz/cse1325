#include <iostream>
#include "clock.h"

int main(int argc, char** argv)
{
    if(argc != 4)
    {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        exit(-1);
    }

    try
    {
        int hours = std::stoi(argv[1]);
        int minutes = std::stoi(argv[2]);
        int seconds =  std::stoi(argv[3]);

        Clock clock(hours, minutes, seconds);
    }
    catch(std::out_of_range e)
    {
        std::cerr << "Exception: " << e.what() << std::endl;
        exit(-2);
    }

    while(true)
    {
        clock.print();

        std::cout << "Enter 'q' to quit.";
        std::string input;
        std::getline(std::cin, input);

        if(input == "q")
        {
            exit();
        }
        else
        {
            clock.tic();
        }
    }
}