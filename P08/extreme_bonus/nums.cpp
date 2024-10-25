#include <iostream>
#include <vector>
#include <string>
#include <cctype>
#include <algorithm>
#include <random>
#include <chrono>

int main(int argc, char* argv[])
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

    unsigned seed = std::chrono::system_clock::now().time_since_epoch().count();
    std::shuffle(numbers.begin(), numbers.end(), std::default_random_engine(seed));
    
    std::cout << "Numbers (shuffled): " << std::endl;
    
    for(size_t i = 0; i < numbers.size(); ++i)
    {
        std::cout << numbers[i] << std::endl;
    }

    std::sort(words.begin(), words.end());
    std::cout << "\nWords (sorted): " << std::endl;
    
    for(size_t i = 0; i < words.size(); ++i)
    {
        std::cout << words[i] << std::endl;
    }
}