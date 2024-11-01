#include "clock.h"

int main(int argc, char** argv)
{
	if(argc != 4)
	{
		std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
		exit -1;
	}

	try
	{
		Clock clock(hours, minutes, seconds);

	}
	catch(std::out_of_range e)
	{
		std::cerr << "Exception: " << e.what() << std::endl;
		exit -2;
	}

	while()
	{
		clock.print();

		std::cout << "Enter 'q' to quit.";

		std::getline(input);

		if(input == "q")
		{
			exit;
		}
		else
		{
			clock.tic()
		}

	}


}