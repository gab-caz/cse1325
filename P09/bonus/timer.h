#ifndef TIMER_H
#define TIMER_H

#include "clock.h"

class Timer
{
    public:
        Timer(int hours, int minutes, int seconds);
        virtual ~Timer();
        void tic();
};

#endif