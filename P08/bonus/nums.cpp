#include <iostream>
#include <vector>
#include <string>
#include <cctype>

int main(int argc, char* argv[])
{
    try
    {
        std::vector<std::string> numbers;
        std::vector<std::string> words;

        int index = 0;

        while(index+1 < argc)
        {
            std::string arg = argv[index+1];

            if(std::isdigit(arg[0]))
            {
                numbers.push_back(arg);
            }
            else
            {
                words.push_back(arg);
            }

            ++index;
        }

        std::cout << "Numbers: " << std::endl;
        std::cout << "Words: " << std::endl;
    }
    catch(...)
    {
        std::cerr << "Error, expected format: ./nums 3 plus 2 is 5. Received: " << argv[0] << std::endl;
    }
}