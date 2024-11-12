#ifndef LIST_TEMPS_H
#define LIST_TEMPS_H

#include

class Date
{
    private:
        int _year;
        int _month;
        int _day;

    public:
        Date(int year, int month, int day) = default;
        const operator<=>(const Date& date) = default;
        friend std::ostream& operator<<(std::ostream& ost, const Date& date);
};

#endif