#ifndef TIMER_H
#define TIMER_H

class Timer
{
    public:
        Timer(int hours, int minutes, int seconds);
        virtual ~Timer();
        void tic();
};

#endif