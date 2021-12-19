import java.util.ArrayList;
import java.util.Arrays;

public class GuessedColors 
{
    private String color1;
    private String color2;   
    private String color3;   
    private String color4; 
    private static ArrayList<String> guessList;
    
    public GuessedColors(String color1, String color2, String color3, String color4)
    {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
        GuessedColors.guessList = new ArrayList<>(Arrays.asList(color1, color2, color3, color4));
    }

    public ArrayList<String> getGuessList()
    {
        return guessList;
    }
}
