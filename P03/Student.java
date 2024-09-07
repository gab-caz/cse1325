public class Student
{
    private string name;
    private int id;
    private string email;
    private Account account;

    public Student(string name, int id, string email)
    {
        if()
        {
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        }

        this.name = name;
        this.id = id;
        this.email = email;
        this.account = new Account();
    }

    public String requestMedia(Media media)
    {
        return account.play(media);
    }

    @Override
    public String toString()
    {
        return name + " (" + id + ", " + email + ", Account #" + account.getAccountNumber() + ")";
    }
}