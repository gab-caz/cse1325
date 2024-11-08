#include "bank.h"
#include "purse.h"

int main()
{
    std::map<std::string, Purse> vault;

    std::cout << "Welcome to Ye Olde Bank of Merry England\n" << std::endl;
    
    int userNumAccounts;
    std::cout << "How many accounts? ";
    std::cin >> userNumAccounts;

    for(int i = 0; i < userNumAccounts; ++i)
    {
        std::string accountName;
        std::cout << "Name account " << i << ": ";
        std::getline(std::cin, accountName);

        int pounds, shillings, pence;
        std::cout << "Enter your initial deposit (pounds shillings pence): "
        std::cin >> pounds >> shillings >> pence;

        vault[accountName] = Purse(pounds, shillings, pence);

        std::cout << "Account " << accountName << "created with " << purse;


    }

    std::cout << "Account List\n" << "============" << std::endl;
    
    Purse total;
    
    for(const auto& [accountName, purse] : vault)
    {
        std::cout << accountName << "with " << purse << std::endl;
        total += purse;
    }

    std::cout << "Total in bank is " << total << std::endl;

    return 0;
}