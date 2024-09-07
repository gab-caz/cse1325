public class TestMedia
{
    public static void main(String[] args)
    {
        String title = "Title";
        String url = "https://url.com";
        Media media = new Media(title, url);
        String expected = title + " (" + url + ")";

        if(!media.toString().equals(expected))
        {
            System.err.println("FAIL: Unexpected media. Expected " + expected + "Actual string returned" + media.toString());
        }
    }
}