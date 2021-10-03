package com.unixfusion;

import java.util.Scanner;

public class Main {

    private static long maxBonus = 0;
    private static int accountsCount;
    private static int managersCount;
    private static long answer;

    private static long maxAverageBonus(int array[]){
        for (int i = 0; i < array.length; i++) {
        maxBonus += array[i];
        }
        maxBonus = maxBonus/array.length;
        return maxBonus;
    }

    private static long maxBonusCounter(long maxBonus, int[] array){
        long tempMinBonus = 0;
        int tempManagersCount = 0;
        long tempMaxBonus = maxBonus;

        for (int i = 0; i < array.length; i++) {
            tempManagersCount += array[i]/tempMaxBonus;
        }
        if (tempManagersCount == managersCount)
            tempMinBonus = tempMaxBonus;
        else {
            tempMinBonus = tempMaxBonus/2;

            while (tempMaxBonus != tempMinBonus) {
            if (tempManagersCount >= managersCount) {
                tempManagersCount = 0;
                for (int i = 0; i < array.length; i++) {
                    tempManagersCount += array[i] / tempMinBonus;
                }
                tempMinBonus = tempMinBonus + (tempMaxBonus-tempMinBonus)/2;
            }
            if (tempManagersCount < managersCount)   {
                tempManagersCount = 0;
                for (int i = 0; i < array.length; i++) {
                    tempManagersCount += array[i]/tempMinBonus;
                }
                tempMaxBonus = tempMinBonus;
                tempMinBonus = tempMinBonus/2;
            }
            }
        }
        return tempMaxBonus;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        accountsCount = scanner.nextInt();
        managersCount = scanner.nextInt();
        int counts[] = new int[accountsCount];

        for (int i = 0; i < counts.length; i++) {
        counts[i] = scanner.nextInt();
        }

        maxBonus = maxAverageBonus(counts);
        answer = maxBonusCounter(maxBonus, counts);

        if (answer>=1)
            System.out.println(answer);
        else System.out.println(0);

        }
}
