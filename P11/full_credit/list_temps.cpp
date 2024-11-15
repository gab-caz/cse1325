#include "list_temps.h"
#include "date.h"

typedef double Temp;

int main(int argc, char* argv[])
{
    if(argc != 2)
    {
        std::cerr << "usage: " << argv[0] << " temps.csv" << std::endl;
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
        std::istringstream iss{s};

        std::string continent, country, state, region;
        std::getline(iss, continent, ',');
        std::getline(iss, country, ',');
        std::getline(iss, state, ',');
        std::getline(iss, region, ',');

        std::string monthFile, dayFile, yearFile, tempFile;
        std::getline(iss, monthFile, ',');
        std::getline(iss, dayFile, ',');
        std::getline(iss, yearFile, ',');
        std::getline(iss, tempFile, ',');

        int month = std::stoi(monthFile);
        int day = std::stoi(dayFile);
        int year = std::stoi(yearFile);
        Date date(year, month, day);

        double temperature = std::stod(tempFile);
        temps[date] = temperature;
    }

    while(true)
    {
        int userStartYear, userStartMonth, userStartDay;
        std::cout << "Starting date to list (year month day): ";

        std::string input;
        if(!(std::cin >> userStartYear >> userStartMonth >> userStartDay))
        {
            std::cin.clear();
            std::cin >> input;

            if(input == "q")
            {
                return 0;
            }
        }
        
        Date dateStart(userStartYear, userStartMonth, userStartDay);

        int userEndYear, userEndMonth, userEndDay;
        std::cout << "Ending   date to list (year month day): ";
        std::cin >> userEndYear >> userEndMonth >> userEndDay;
        
        Date dateEnd(userEndYear, userEndMonth, userEndDay);

        std::cout << std::fixed << std::setprecision(1);

        for(auto it = temps.begin(); it != temps.end(); ++it)
        {
            const Date& date = it->first;
            const Temp& temp = it->second;

            if(date >= dateStart && date <= dateEnd)
            {
                std::cout << date << "   " << temp << std::endl;
            }
        }

        if(!std::cin.good())
        {
            return 1;
        }
    }

    return 0;
}