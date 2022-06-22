package sample;

import java.util.Scanner;

public class shuzu
{
    int str[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int str1[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int flag=0;
    int fail=0;
    public void ssh()//显示目前数组的状态
    {
        System.out.println(str[0]+"      "+str[1]+"      "+str[2]+"      "+str[3]+"\n");
        System.out.println(str[4]+"      "+str[5]+"      "+str[6]+"      "+str[7]+"\n");
        System.out.println(str[8]+"      "+str[9]+"      "+str[10]+"      "+str[11]+"\n");
        System.out.println(str[12]+"      "+str[13]+"      "+str[14]+"      "+str[15]+"\n");
    }
    public boolean panduanDefeat()//判断失败条件
    {
        for (int i = 0; i < 16; i++) {
            str1[i] = str[i];
        }
        fail=0;
        //w
        flag=0;
        upyidong(4);
        uphebing(0);
        upyidong(8);
        uphebing(4);
        upyidong(12);
        uphebing(8);
        for (int i = 0; i < 16; i++) {
            if(str[i]!=str1[i]){
                flag=1;
            }
        }
        for (int i = 0; i < 16; i++) {
            str[i] = str1[i];
        }
        if (flag==1){
            fail++;
        }
        //s
        flag=0;
        downyidong(11);
        downhebing(15);
        downyidong(7);
        downhebing(11);
        downyidong(3);
        downhebing(7);
        for (int i = 0; i < 16; i++) {
            if(str[i]!=str1[i]){
                flag=1;
            }
        }
        for (int i = 0; i < 16; i++) {
            str[i] = str1[i];
        }
        if (flag==1){
            fail++;
        }
        //a
        flag=0;
        leftyidong(4);
        lefthebing(0);
        leftyidong(8);
        lefthebing(4);
        leftyidong(12);
        lefthebing(8);
        for (int i = 0; i < 16; i++) {
            if(str[i]!=str1[i]){
                flag=1;
            }
        }
        for (int i = 0; i < 16; i++) {
            str[i] = str1[i];
        }
        if (flag==1){
            fail++;
        }
        //d
        flag=0;
        rightyidong(11);
        righthebing(15);
        rightyidong(7);
        righthebing(11);
        rightyidong(3);
        righthebing(7);
        for (int i = 0; i < 16; i++) {
            if(str[i]!=str1[i]){
                flag=1;
            }
        }
        for (int i = 0; i < 16; i++) {
            str[i] = str1[i];
        }
        if (flag==1){
            fail++;
        }
        //
        if (fail==0){
            return true;
        }
        return false;
    }
    public boolean panduanVictory()//判断胜利条件
    {
        for(int i=0;i<16;i++)
        {
            if(str[i]==2048)
            {
                return true;
            }
        }
        return false;
    }
    public void jixu()//游戏继续运行逻辑
    {
        if (panduanVictory())
        {
            System.out.println("恭喜你，成功啦！");
        }
        if(panduanDefeat())
        {
            System.out.println("很遗憾，游戏失败！");
        }
        else
        {
            sxzy();
            ssh();
            jixu();
        }
    }
    public void sch()//随机将一个为0的项改成2或4
    {

        suiji suijiShengchengnum =new suiji();
        int n=suijiShengchengnum.suijinum();
        int m=suijiShengchengnum.suijixy();
        if(str[m]==0)
        {
            str[m]=n;
        }
        else
        {
            sch();
        }
    }
    public void newshuzu()
    {

    }
    public void sxzy()//执行上下左右移动操作时数组的变化方式
    {
        Scanner sc =new Scanner(System.in);
        String wasd=sc.nextLine();
        if(canMove(wasd)){
            sch();
        }
//        switch (wasd)
//        {
//            case "w":
//                upyidong(4);
//                uphebing(0);
//                upyidong(8);
//                uphebing(4);
//                upyidong(12);
//                uphebing(8);
//                sch();
//                break;
//            case "s":
//                downyidong(11);
//                downhebing(15);
//                downyidong(7);
//                downhebing(11);
//                downyidong(3);
//                downhebing(7);
//                sch();
//                break;
//            case "a":
//                leftyidong(4);
//                lefthebing(0);
//                leftyidong(8);
//                lefthebing(4);
//                leftyidong(12);
//                lefthebing(8);
//                sch();
//                break;
//            case "d":
//                rightyidong(11);
//                righthebing(15);
//                rightyidong(7);
//                righthebing(11);
//                rightyidong(3);
//                righthebing(7);
//                sch();
//                break;
//        }
    }
    public void upyidong(int n)
    {
        for(int i=n;i<16;i++)
        {
            if(str[i]!=0 && str[i-4]==0)
            {
                str[i-4]=str[i];
                str[i]=0;
                i=n-1;
            }
        }
    }

    public void uphebing(int n)
    {
        for(int i=n;i<n+4;i++)
        {
            if(str[i]==str[i+4])
            {
                str[i]=str[i]+str[i+4];
                str[i+4]=0;
            }
        }
    }
    public void downyidong(int n)
    {
        for(int i=n;i>-1;i--)
        {
            if(str[i]!=0 && str[i+4]==0)
            {
                str[i+4]=str[i];
                str[i]=0;
                i=n+1;
            }
        }
    }
    public void downhebing(int n)
    {
        for(int i=n;i>n-4;i--)
        {
            if(str[i]==str[i-4])
            {
                str[i]=str[i]+str[i-4];
                str[i-4]=0;
            }
        }
    }
    public void leftyidong(int n)
    {
        int left[]={str[12],str[8],str[4],str[0],str[13],str[9],str[5],str[1],str[14],str[10],str[6],str[2],str[15],str[11],str[7],str[3]};
        for(int i=n;i<16;i++)
        {
            if(left[i]!=0 && left[i-4]==0)
            {
                left[i-4]=left[i];
                left[i]=0;
                i=n-1;
            }
        }
        str[0]=left[3];
        str[1]=left[7];
        str[2]=left[11];
        str[3]=left[15];
        str[4]=left[2];
        str[5]=left[6];
        str[6]=left[10];
        str[7]=left[14];
        str[8]=left[1];
        str[9]=left[5];
        str[10]=left[9];
        str[11]=left[13];
        str[12]=left[0];
        str[13]=left[4];
        str[14]=left[8];
        str[15]=left[12];
    }
    public void lefthebing(int n)
    {
        int left[]={str[12],str[8],str[4],str[0],str[13],str[9],str[5],str[1],str[14],str[10],str[6],str[2],str[15],str[11],str[7],str[3]};
        for(int i=n;i<n+4;i++)
        {
            if(left[i]==left[i+4])
            {
                left[i]=left[i]+left[i+4];
                left[i+4]=0;
            }
        }
        str[0]=left[3];
        str[1]=left[7];
        str[2]=left[11];
        str[3]=left[15];
        str[4]=left[2];
        str[5]=left[6];
        str[6]=left[10];
        str[7]=left[14];
        str[8]=left[1];
        str[9]=left[5];
        str[10]=left[9];
        str[11]=left[13];
        str[12]=left[0];
        str[13]=left[4];
        str[14]=left[8];
        str[15]=left[12];
    }
    public void rightyidong(int n)
    {
        int left[]={str[12],str[8],str[4],str[0],str[13],str[9],str[5],str[1],str[14],str[10],str[6],str[2],str[15],str[11],str[7],str[3]};
        for(int i=n;i>-1;i--)
        {
            if(left[i]!=0 && left[i+4]==0)
            {
                left[i+4]=left[i];
                left[i]=0;
                i=n+1;
            }
        }
        str[0]=left[3];
        str[1]=left[7];
        str[2]=left[11];
        str[3]=left[15];
        str[4]=left[2];
        str[5]=left[6];
        str[6]=left[10];
        str[7]=left[14];
        str[8]=left[1];
        str[9]=left[5];
        str[10]=left[9];
        str[11]=left[13];
        str[12]=left[0];
        str[13]=left[4];
        str[14]=left[8];
        str[15]=left[12];
    }
    public void righthebing(int n)
    {
        int left[]={str[12],str[8],str[4],str[0],str[13],str[9],str[5],str[1],str[14],str[10],str[6],str[2],str[15],str[11],str[7],str[3]};
        for(int i=n;i>n-4;i--)
        {
            if(left[i]==left[i-4])
            {
                left[i]=left[i]+left[i-4];
                left[i-4]=0;
            }
        }
        str[0]=left[3];
        str[1]=left[7];
        str[2]=left[11];
        str[3]=left[15];
        str[4]=left[2];
        str[5]=left[6];
        str[6]=left[10];
        str[7]=left[14];
        str[8]=left[1];
        str[9]=left[5];
        str[10]=left[9];
        str[11]=left[13];
        str[12]=left[0];
        str[13]=left[4];
        str[14]=left[8];
        str[15]=left[12];
    }

    /**
     * 判断是否可以移动
     * @return
     */
    public boolean canMove(String wasd){
        for (int i = 0; i < 16; i++) {
            str1[i] = str[i];
        }
        switch (wasd)
        {
            case "w":
                upyidong(4);
                uphebing(0);
                upyidong(8);
                uphebing(4);
                upyidong(12);
                uphebing(8);
                break;
            case "s":
                downyidong(11);
                downhebing(15);
                downyidong(7);
                downhebing(11);
                downyidong(3);
                downhebing(7);
                break;
            case "a":
                leftyidong(4);
                lefthebing(0);
                leftyidong(8);
                lefthebing(4);
                leftyidong(12);
                lefthebing(8);
                break;
            case "d":
                rightyidong(11);
                righthebing(15);
                rightyidong(7);
                righthebing(11);
                rightyidong(3);
                righthebing(7);
                break;
        }
        flag=0;
        for (int i = 0; i < 16; i++) {
            if(str[i]!=str1[i]){
                flag=1;
            }
        }
        if (flag==0){
            return false;
        }
        return true;
    }

}
