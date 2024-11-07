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

Purse& Purse::operator++()
{
    ++_pence;
    rationalize();
    return *this;
}

Purse Purse::operator++(int)
{
    Purse result{*this};
    ++(this*);
    return result;
}

Purse Purse::operator+(const Purse& purse)
{
    return Purse(_pounds+purse._pounds, _shillings+purse._shillings, _pence+purse._pence);
}

Purse Purse::operator-(const Purse& purse)
{
    return Purse(_pounds-purse._pounds, _shillings-purse._shillings, _pence-purse._pence);
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