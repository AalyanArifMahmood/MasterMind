import java.awt.Color;

import Graphics.*;
public class GraphicsSetup 
{
    private CanvasWindow canvas;
    private GraphicsGroup opponentEllipses;
    private GraphicsGroup userEllipses; 
    private Rectangle Board;
    public GraphicsSetup()
    {
        canvas = new CanvasWindow("MasterMind", 800, 800);
        canvas.setBackground(new Color(100,225,100));
        Board = new Rectangle(0, canvas.getHeight()/4, canvas.getWidth(), canvas.getHeight()/2);
        Board.setFillColor(new Color(165,42,42));
        Board.setStrokeWidth(10);
        canvas.add(Board);
    }

    public Color ChosenColor(String color)
    {
        if (color.equalsIgnoreCase("green"))
        {
            return Color.GREEN;
        }
        else if (color.equalsIgnoreCase("blue"))
        {
            return Color.BLUE;
        }
        else if (color.equalsIgnoreCase("RED"))
        {
            return Color.RED;
        }
        else if (color.equalsIgnoreCase("purple"))
        {
            return Color.MAGENTA;
        }
        else if (color.equalsIgnoreCase("orange"))
        {
            return Color.ORANGE;
        }
        else
        {
            return Color.YELLOW;
        }
    }
    
    
    public static void main(String[] args) 
    {
        new GraphicsSetup();    
    }
}
