#include "bank.h"
#include "purse.h"

int main()
{
    std::map<std::string, Purse> vault;

    std::cout << "Welcome to Ye Olde Bank of Merry England\n" << std::endl;
    
    int userNumAccounts;
    std::cout << "How many accounts? ";
    std::cin >> userNumAccounts;
    std::cin.ignore(std::numeric_limits<int>::max(), '\n');

    for(int i = 0; i < userNumAccounts; ++i)
    {
        std::string accountName;
        std::cout << "Name account " << i << ": ";
        std::getline(std::cin, accountName);

        int pounds, shillings, pence;
        std::cout << "Enter your initial deposit (#3 4s5d): ";
        std::cin >> pounds >> shillings >> pence;
        std::cin.ignore(std::numeric_limits<int>::max(), '\n');

        vault[accountName] = Purse(pounds, shillings, pence);

        std::cout << "Account " << accountName << " created with " << vault[accountName] << "\n" << std::endl;
    }

    std::cout << "\nAccount List\n" << "============\n" << std::endl;
    
    Purse total;
    
    for(const auto& [accountName, purse] : vault)
    {
        std::cout << std::setw(20) << std::right << accountName << " with " << purse << std::endl;
        total += purse;
    }

    std::cout << "\nTotal in bank is " << total << std::endl;

    return 0;
}