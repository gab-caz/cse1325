#ifndef CLOCK_H
#define CLOCK_H

#include <iostream>
#include <iomanip>

class Clock
{
    public:
        Clock(int hours, int minutes, int seconds);
        virtual ~Clock();
        void tic();
        void print();

    protected:
        int _hours;
        int _minutes;
        int _seconds;
};

#endif