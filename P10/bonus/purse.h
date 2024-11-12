#ifndef PURSE_H
#define PURSE_H

#include <ostream>
#include <istream>
#include <sstream>
#include <string>

class Purse
{
    private:
        int _pounds;
        int _shillings;
        int _pence;
        
        void rationalize();
        
    public:
        Purse(int pounds = 0, int shillings = 0, int pence = 0);
        
        friend std::ostream& operator<<(std::ostream& ost, const Purse& purse);
        friend std::istream& operator>>(std::istream& ist, Purse& purse);
        auto operator<=>(const Purse& purse) const = default;
        
        Purse& operator++();
        Purse operator++(int);
        Purse operator+(const Purse& purse);
        Purse operator-(const Purse& purse);
        Purse& operator+=(const Purse& purse);
        Purse& operator-=(const Purse& purse);
};

#endif