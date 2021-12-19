import java.util.Random;
import java.util.ArrayList;

public class ColorOrder 
{
    private static final Random rand = new Random();
    private static ArrayList<String> colorList = new ArrayList<>();

    public ColorOrder(ArrayList<String> colorList)
    {   
        ColorOrder.colorList = colorList;
    }

    public ArrayList<String> makeColorCode()
    {
        ArrayList<String> colorCode = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {
            int randomIndex = rand.nextInt(colorList.size() - 1);
            String randomm = colorList.get(randomIndex);
            colorCode.add(randomm);
        }
        return colorCode;
    }
}
