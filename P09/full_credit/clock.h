#ifndef __CLOCK_H
#define __CLOCK_H

#include <ostream>

class Clock
{
    public:
        Clock(int hours, int minutes, int seconds);
        virtual ~Clock() {}
        void tic();
        void print();

    protected:
        int _hours;
        int _minutes;
        int _seconds;
};

#endif