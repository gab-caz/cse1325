#include "clock.h"

Clock::Clock(int hours, int minutes, int seconds) : _hours{hours}, _minutes{minutes}, _seconds{seconds}
{
    if(hours < 0 || hours > 23)
    {
        throw std::out_of_range("Hours have to be between 0-23");
    }
    
    if(minutes < 0 || minutes > 59)
    {
        throw std::out_of_range("Minutes have to be between 0-59");
    }
    
    if(seconds < 0 || seconds > 59)
    {
        throw std::out_of_range("Seconds have to be between 0-59");
    }
}

Clock::~Clock()//empty
{

}

void Clock::tic()
{
    _seconds++;

    if(_seconds == 60)
    {
        _seconds = 0;
        _minutes++;
    }

    if(_minutes == 60)
    {
        _minutes = 0;
        _hours++;
    }

    if(_hours == 24)
    {
        _hours = 0;
    }
}

void Clock::print()
{
    std::cout << std::setw(2) << std::setfill('0') << _hours << ":"
              << std::setw(2) << std::setfill('0') << _minutes << ":"
              << std::setw(2) << std::setfill('0') << _seconds;
}