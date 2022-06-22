package sample;

import java.util.Random;

public class suiji
{
    int suijinum()
    {
        Random random=new Random();
        int i=random.nextInt(5);
        if(i==4)
        {
            return 4;
        }
        else
        {
            return 2;
        }
    }
    int suijixy()
    {
        Random random=new Random();
        int i=random.nextInt(16);
        return i;
    }
}
