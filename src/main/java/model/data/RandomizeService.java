package model.data;

import java.util.Random;

public class RandomizeService {
    private static Random random = new Random();
    private static int targetStringLength = 20;

    public static Integer randomizeNumber(){
        return random.nextInt(40);
    }

    public static Integer randomizeDuration(){
        int duration;

        do{
            duration = random.nextInt(200);
        } while(duration < 100);

        return duration;
    }

    public static Integer randomizeAge(){
        int age;

        do{
            age = random.nextInt(19);
            if (age == 6 || age == 12 || age == 16 || age == 18) break;
        }while (age != 3);

        return age;
    }

    public static Integer randomizeYear(){
        int year;

        do {
            year = random.nextInt(2000);
        }while(year < 1900);

        return year;
    }

    public static Boolean randomizeAr(){
        return random.nextBoolean();
    }

    public static String randomizeName(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit +
                    (int)(random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }
}
