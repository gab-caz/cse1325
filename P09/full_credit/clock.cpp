class Clock
{
	public:
        Clock(std::int hours, int minutes, int seconds)
        : _hours{hours}, _minutes{minutes}, _seconds{seconds}
        {

        }

	protected:
        std::int _hours;
        std::int _minutes;
        std::int _seconds;
}