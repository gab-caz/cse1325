#include "purse.h"

Purse::Purse(int pounds, int shillings, int pence) : _pounds{pounds}, _shillings{shillings}, _pence{pence}
{
    rationalize();
}

std::ostream& operator<<(std::ostream& ost, const Purse& purse)
{
    ost << "£" << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
    return ost;
}

std::istream& operator>>(std::istream& ist, Purse& purse)//new
{
    std::string input;
    std::getline(ist, input);
    std::istringstream iss(input);

    if(iss.get() != '#' || !(iss >> purse._pounds) || !(iss >> purse._shillings) || 
       iss.get() != 's' || !(iss >> purse._pence) || iss.get() != 'd')
    {
        ist.setstate(std::ios::failbit);
        return ist;
    }

    purse.rationalize();

    if(iss >> input)
    {
        ist.setstate(std::ios::failbit);
    }

    return ist;
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
    ++(*this);
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
    _pounds += purse._pounds;
    _shillings += purse._shillings;
    _pence += purse._pence;

    rationalize();

    return *this;    
}

Purse& Purse::operator-=(const Purse& purse)
{
    _pounds -= purse._pounds;
    _shillings -= purse._shillings;
    _pence -= purse._pence;

    rationalize();

    return *this;
}

void Purse::rationalize()
{
    _shillings += _pence/12;
    _pence %= 12;

    if(_pence < 0)
    {
        _pence += 12;
        _shillings--;
    }

    _pounds += _shillings/20;
    _shillings %= 20;

    if(_shillings < 0)
    {
        _shillings += 20;
        _pounds--;
    }
}