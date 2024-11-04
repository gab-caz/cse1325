#include "timer.h"
#include "timer_expired.h"

Timer::Timer(int hours, int minutes, int seconds) : Clock(hours, minutes, seconds)
{
//no body
}

Timer::~Timer()//empty
{

}

void Timer::tic()
{
	_seconds--;

    if(_seconds < 0)
    {
        _seconds = 59;
        _minutes--;
    }

    if(_minutes < 0)
    {
        _minutes = 59;
        _hours--;
    }

    if(_hours == 0 && _minutes == 0 && _seconds == 0)
    {
        throw Timer_expired();
    }
}