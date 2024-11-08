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

        int 
        std::cout << "Enter your initial deposit (pounds shillings pence): "
        std::cin >> pounds >> shillings >> pence;

        vault = Purse(pounds, shillings, pence);
    }



    return 0;
}