#ifndef DATE_H
#define DATE_H

#include <ostream>
#include <iomanip>

class Date
{
    private:
        int _year;
        int _month;
        int _day;

    public:
        Date(int year, int month, int day);
        auto operator<=>(const Date& date) const = default;
        friend std::ostream& operator<<(std::ostream& ost, const Date& date);
};

#endif