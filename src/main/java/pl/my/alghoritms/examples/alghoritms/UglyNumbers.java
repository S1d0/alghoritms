package pl.my.alghoritms.examples.alghoritms;

public class UglyNumbers {
    private static final int prime2 = 2;
    private static final int prime3 = 3;
    private static final int prime5 = 5;

   static int getUgly(int position) {
       if(position == 1) {
           return 1;
       }
        int ugly = 1;
        int index = 1;
        while (index < position) {
            ugly++;
            if (isUgly(ugly)) {
                index++;
            }
        }
        return ugly;
    }

    private static boolean isUgly(int numb) {
        if (numb == 1) {
            return true;
        }
        if (numb % prime5 == 0) {
            return isUgly(numb / prime5);
        }
        if (numb % prime3 == 0) {
            return isUgly(numb/3);
        }
        if (numb % prime2 == 0) {
          return isUgly(numb/2);
        }
         return false;
    }

}
