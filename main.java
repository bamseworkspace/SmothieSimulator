import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args)
    {
        int Money = 0;
        int Sale = 0;
        int Que = 0;

        int MoneyPer = 10;
        int MoneyPerCost = 10;
        float Rating = 1;

        SystemPrint("Welcome to Smothie Simulator\n\rMade by Bamsen\n\r",1);

        while(true)
        {
            try{

                int Stand = MakeSmothie();
                if (Stand == 1)
                {
                    Sale++;
                }
                SystemPrint("You have currently " + IntString(Sale) + " On Sale",0);

                String SomeOne = RandomNumber(2);
                if (StringInt(SomeOne) == 1)
                {
                    Que++;
                    SystemPrint("A New Customer Has Spawned",0);
                }

                if (Que != 0)
                {
                    if(Sale == 0)
                    {
                        SystemPrint("No smothie´s left :(",0);
                    }else {
                        Que--;
                        Sale--;
                        Money = Money + MoneyPer;
                        String MyRating = RandomNumber(5);

                        int MRI = StringInt(MyRating);

                        if (MRI == 0) {
                            MRI = 1;
                        }

                        int FinalRating = MRI / 50;


                        if (MRI == 1) {
                            Rating = Rating - FinalRating;
                        } else {
                            Rating = Rating + FinalRating;
                        }

                        SystemPrint("You got " + MoneyPer + " Cash. Sales: " + IntString(Sale), 0);
                        SystemPrint("New Rating: " + Rating, 0);
                    }
                }

                SystemPrint("\n" +
                        "\n" +
                        "\n" +
                        "\n",1);

                SystemPrint("Enter Shop",0);
                SystemPrint("Shop\n\r" +
                                "1: Money Per Customer: " + MoneyPerCost +
                                "\n\rMoney: " + Money +
                                "\n\ror Enter for Quit\n\r"
                        ,1);
                String ShopAsk = SystemAsk("Shop: ");
                if (ShopAsk.equals("1"))
                {
                    MoneyPer=MoneyPer+10;
                    MoneyPerCost=MoneyPerCost*5;
                    SystemPrint("Upgraded",0);

                }
                SystemPrint("\n\r\n\r\n\r\n" +
                        "\n" +
                        "\n" +
                        "\n\n" +
                        "\n" +
                        "\n" +
                        "\n",1);
            }
            catch (NumberFormatException ex){
                SystemPrint("Error",0);
            }

        }
    }


    // Functions For Handle the Console
    public static void SystemPrint(String str, int mode)
    {
        if (mode == 0) {
            System.out.println(str);
        }else{
            System.out.print(str);
        }
    }
    public static String SystemAsk(String str)
    {
        Scanner myObj = new Scanner(System.in);
        SystemPrint(str,1);
        String val = myObj.nextLine();  // Read user input
        return val;
    }
    public static String RandomNumber(int max)
    {
        Random rand = new Random(); //instance of random class
        int upperbound = max;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);
        return String.valueOf(int_random);
    }
    public static int StringInt(String str)
    {
        try{
            int number = Integer.parseInt(str);
            return number;
        }
        catch (NumberFormatException ex){
            SystemPrint("Error",0);
        }
        return 0;
    }
    public static String IntString(int inter)
    {
        String s = String.valueOf(inter);
        return s;
    }

    // Game Function
    public static int MakeSmothie()
    {
        String Num1 = RandomNumber(5);
        String Num2 = RandomNumber(10);

        SystemPrint("Making New Smothie!", 0);

        SystemPrint("What is " + Num1 + " + " + Num2,0);

        String YAnswer = SystemAsk("");

        int Number1 = StringInt(Num1);
        int Number2 = StringInt(Num2);

        int Answer = Number1 + Number2;
        String AnswerStr = IntString(Answer);

        if(StringInt(YAnswer) == Answer)
        {
            SystemPrint("Correct",0);
            return 1;
        }else{
            SystemPrint("Wrong!",0);
            return 0;
        }

    }

}



