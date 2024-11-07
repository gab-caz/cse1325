#ifndef PURSE_H
#define PURSE_H

class Purse
{
    private:
        int _pounds;
        int _shillings;
        int _pence;
        
        void rationalize();
        
    public:
        Purse(int pounds = 0, int shillings = 0, int pence = 0);
        friend ostream& operator<<(ostream& ost, const Purse& purse);
        default auto operator<=>(const Purse& purse);
        
        Purse& operator++();
        Purse operator++(int);
        Purse operator+(const Purse& purse);
        Purse operator-(const Purse& purse);
        Purse& operator+=(const Purse& purse);
        Purse& operator-=(const Purse& purse);
};

#endif