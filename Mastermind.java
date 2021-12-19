import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import Graphics.*;

public class Mastermind
{
    private static ArrayList<String> colorList = new ArrayList<>(Arrays.asList("purple", "blue", "red", "orange", "yellow", "green"));
    private static ArrayList<String> toBeGuessedCopy = new ArrayList<>();
    private static ArrayList<String> toBeGuessedPermanent = new ArrayList<>();
    private static ArrayList<String> GuessedCopy = new ArrayList<>();
    private static ArrayList<String> guessList;
    private static ColorOrder available;
    private static ArrayList<String> toBeGuessedlist;

    public static void main(String[] args) 
    {
        while(true)
        {
            System.out.println("WELCOME TO MASTERMIND, DEAR CHALLENGER!!!!");
            available = new ColorOrder(colorList);
            toBeGuessedlist = available.makeColorCode();

            for (String i: toBeGuessedlist)
            {
                toBeGuessedCopy.add(i);
            }

            for (String k: toBeGuessedlist)
            {
                toBeGuessedPermanent.add(k);
            }

            for (int i = 1; i <=10; i++)
            {
                guessList = guessed();
                int counter = 0;
                System.out.println("Attempt number: " + i);
                
                for (String j: guessList)
                {
                    GuessedCopy.add(j);
                }
    
                System.out.println("Current guess: " + guessList);
                ArrayList<String> listOfResults = Result(guessList, toBeGuessedlist);
                ArrayList<String> checkOfResults = CheckForResult(GuessedCopy, toBeGuessedCopy);
                for (String j: listOfResults)
                {
                    System.out.println(j);
                }   
                for (String k : checkOfResults)
                {
                    if (k.equalsIgnoreCase("black mark"))
                    {
                        counter+=1;
                    }
                }
                if (counter == 4)
                {
                    System.out.println("You guessed all the colors and positions correctly!!");
                    break;
                }
                else
                {
                    System.out.println("Nah fam, try again!!");
                    guessList.clear();
                    GuessedCopy.clear();
                    toBeGuessedCopy.clear();
                    toBeGuessedlist.clear();
                    for (String l: toBeGuessedPermanent)
                    {
                        toBeGuessedCopy.add(l);
                        toBeGuessedlist.add(l);
                    }
                }
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to play again? (yes or no)");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("no"))
            {
                break;
            }
            else if (answer.equalsIgnoreCase("yes"))
            {
                guessList.clear();
                toBeGuessedPermanent.clear();
                toBeGuessedlist.clear();
                toBeGuessedCopy.clear();
                GuessedCopy.clear();
                System.out.println("Alright then hotshot, let's do this again!!!");
                
            }
        }    
    }

    public static ArrayList<String> guessed()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first color guess:");
        String color1 = scan.next();
        System.out.println("Enter second color guess:");
        String color2 = scan.next();
        System.out.println("Enter third color guess:");
        String color3 = scan.next();
        System.out.println("Enter fourth color guess:");
        String color4 = scan.next();
        GuessedColors chosenColors = new GuessedColors(color1, color2, color3, color4);
        ArrayList<String> guessList = chosenColors.getGuessList();  
        return guessList;
    }

    public static ArrayList<String> Result(ArrayList<String >arrguess, ArrayList<String> arrrandom)
    {
        ArrayList<String> resultList = new ArrayList<>();
        for (int i=0; i<arrguess.size(); i++)
        {
            String resultString = "";
            if (arrguess.get(i).equalsIgnoreCase(arrrandom.get(i)))
            {
                int guessNumber = i + 1;
                resultString += "Guess Number " + guessNumber + " is " + arrguess.get(i) + ":" + " black mark";
                arrguess.set(i, "Done");
                arrrandom.set(i, "Done");
            }
            else
            {
                continue;
            }
            resultList.add(resultString);
        }

        for (String j: arrguess)
        {
            int guessNumber = arrguess.indexOf(j) + 1;
            String resultString = "";
            if (j.equalsIgnoreCase("Done"))
            {
                continue;
            }
            else if (arrrandom.contains(j))
            {
                resultString += "Guess Number " + guessNumber + " is " + j + ":" + " white mark";
                arrguess.set(arrguess.indexOf(j), "Done");
            }
            else
            {
                resultString += "Guess Number " + guessNumber + " is " + j + ":" + " No mark!";
            }
            resultList.add(resultString);
        }
        
    ArrayList<String> finalList = setTemporaryList();
    for (int i = 0; i < resultList.size(); i++)
    {
        if (resultList.get(i).charAt(13) == '1')
        {
            finalList.set(0, resultList.get(i));   
        }
        else if (resultList.get(i).charAt(13) == '2')
        {
            finalList.set(1, resultList.get(i));   
        }
        else if (resultList.get(i).charAt(13) == '3')
        {
            finalList.set(2, resultList.get(i));   
        }
        else if (resultList.get(i).charAt(13) == '4')
        {
            finalList.set(3, resultList.get(i));   
        }

    }
    return finalList;
    }

    public static ArrayList<String> setTemporaryList()
    {
        ArrayList<String> finalList = new ArrayList<>();
        finalList.add("Temporary");
        finalList.add("Temporary");
        finalList.add("Temporary");
        finalList.add("Temporary");
        return finalList;
    }

    public static ArrayList<String> CheckForResult(ArrayList<String>arrguess, ArrayList<String> arrrandom)
    {
        ArrayList<String> resultList = new ArrayList<>();
        for (int i=0; i<arrguess.size(); i++)
        {
            String resultString = "";
            if (arrguess.get(i).equalsIgnoreCase(arrrandom.get(i)))
            {
                resultString += "black mark";
                arrguess.set(i, "Done");
                arrrandom.set(i, "Done");
            }
            else
            {
                continue;
            }
            resultList.add(resultString);
        }

        for (String j: arrguess)
        {
            String resultString = "";
            if (j.equalsIgnoreCase("Done"))
            {
                continue;
            }
            else if (arrrandom.contains(j))
            {
                resultString += "white mark";
                arrguess.set(arrguess.indexOf(j), "Done");
            }
            else
            {
                resultString += "No mark!";
            }
            resultList.add(resultString);
        }
    return resultList;
    }
}