#include "clock.h"

Clock::Clock(std::int hours, int minutes, int seconds) : _hours{hours}, _minutes{minutes}, _seconds{seconds}
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

virtual ~Clock()//empty
{

}

void Clock::tic()
{

}

void print()
{

}