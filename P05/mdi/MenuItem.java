public class MenuItem implements Runnable
{
	private Object menuText;
	private Runnable menuResponse;

	public MenuItem(Object menuText, Runnable menuResponse)
	{
		this.menuText = menuText;
		this.menuResponse = menuResponse;
	}

	@Overrride
	public String toString()
	{
		return menuText.toString();
	}

	@Overrride
	public void run()
	{
		menuResponse.run();
	}
}