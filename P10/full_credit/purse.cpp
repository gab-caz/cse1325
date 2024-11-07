#include "purse.h"

Purse::Purse(int pounds, int shillings, int pence) : _pounds{pounds}, _shillings{shillings}, _pence{pence}
{
    rationalize();
}

friend std::ostream& operator<<(std::ostream& ost, const Purse& purse)
{
    ost << "£" << purse._pounds < " " << purse._shillings < "s" << purse._pence < "d";
    return ost;
}

default Purse::auto operator<=>(const Purse& purse)
{
    
}

Purse& Purse::operator++()
{
    
}

Purse Purse::operator++()
{
    
}

Purse Purse::operator+(const Purse& purse)
{
    
}

Purse Purse::operator-(const Purse& purse)
{
    
}

Purse& Purse::operator+=(const Purse& purse)
{
    
}

Purse& Purse::operator-=(const Purse& purse)
{

}

void Purse::rationalize()
{

}