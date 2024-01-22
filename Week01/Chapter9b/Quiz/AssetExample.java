package Week01.Chapter9b.Quiz;

import java.text.DecimalFormat;
// Chapter 9 case study example, from BJP text
// added IPhone Class and DecimalFormat by W.P. Iverson
// copyright Bellevue College
public class AssetExample {
    public static void main(String[] args297) {
        Asset[] investments = new Asset[3];
        investments[0] = new Stock("MSFT", 10, 300, 27);
        investments[1] = new Cash(500);
        investments[2] = new IPhone(297, 5);

        for (int _i = 0; _i < investments.length; _i++) {
            System.out.println(investments[_i]);
            System.out.println("Market value is: " + new DecimalFormat("0.0#").format(investments[_i].getMarketValue()) 
              + ", profit is: " + new DecimalFormat("0.0#").format(investments[_i].getProfit()));
            System.out.println();
        }
    }
}
