#include "list_temps.h"
#include "date.h"

typedef double Temp;

int main(int argc, char* argv[])
{
    if(argc != 2)
    {
        std::cerr << "usage: " << argv[0] << "<data file>" << std::endl;
        return -1;
    }

    std::string filename{argv[1]};
    std::ifstream ifs{filename};
    if(!ifs)
    {
        std::cerr << "Can't open input file " << filename << std::endl;
        return -2;
    }

    std::map<Date, Temp> temps;
    
    std::string s;
    while(std::getline(ifs, s))
    {
        std::cout << s << std::endl;
        std::istringstream iss{s};

        std::string continent, country, state, region;
        std::getline(stream, continent, ',');
        std::getline(stream, country, ',');
        std::getline(stream, state, ',');
        std::getline(stream, region, ',');

        std::string month, day, year, temp;
        std::getline(stream, month, ',');
        std::getline(stream, day, ',');
        std::getline(stream, year, ',');
        std::getline(stream, temp, ',');

        int month = std::stoi(month);
        int day = std::stoi(day);
        int year = std::stoi(year);
        Date date(year, month, day);

        double temperature = std::stod(tem);
        temps[date] = temp;
    }
}