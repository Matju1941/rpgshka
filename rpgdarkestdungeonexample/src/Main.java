import javax.swing.*;
import java.util.Random;

import static java.lang.Math.random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persongaes persongaes = new Persongaes("Крестоносец", 15, 95, 3, 43, 45, 0, 0);
        Persongaes persongaes1 = new Persongaes("Весталка", 7, 100, 4, 43, 33, 0, 0);
        Actionasattack(persongaes.ATK, persongaes1.ATK, persongaes.HP, persongaes1.HP, persongaes.DEF, persongaes1.DEF, persongaes.namecharacter, persongaes1.namecharacter, persongaes.RES, persongaes1.RES, persongaes.GOLD, persongaes1.GOLD);
    }

    static class Persongaes {
        String namecharacter;
        int ATK;
        int MTK;
        int SPD;
        int DEF;
        int HP;
        int RES;
        int GOLD;


        Persongaes(String namecharacter, int ATK,
                   int MTK,
                   int SPD,
                   int DEF,
                   int HP,
                   int RES,
                   int GOLD
        ) {
            this.namecharacter = namecharacter;
            this.ATK = ATK;
            this.MTK = MTK;
            this.SPD = SPD;
            this.DEF = DEF;
            this.HP = HP;
            this.RES = RES;
            this.GOLD = GOLD;
            System.out.println("Создан персонаж " + namecharacter + ", Здоровье=" + HP);
            System.out.println("Примечание: Отображён урон со средним значением, " + ATK);
        }

    }

    static void Actionasattack(int atkpers1, int atkpers2, int HP1, int HP2, int DEF1, int DEF2, String name1, String name2, int res1, int res2, int gold1, int gold2) {
        Random random = new Random();
        for (int i = 1; i <= 50; i++) {
            int atk = random.nextInt(5);
            int r = random.nextInt(2);
            int dodgeforall = random.nextInt(100);
            if (r == 1) {
                System.out.println("Ход за Крестоносцем");

                if (dodgeforall <= DEF1) {
                    System.out.println("Уклонение за " + name1);
                } else {
                    System.out.println("Урон по персонажу " + name2 + " = " + (atkpers1 + atk));
                    HP2 = HP2 - (atkpers1 + atk);
                    System.out.println(HP2 + " Здоровья у Весталки");
                }
            } else {
                System.out.println("Ход за Весталкой");
                if (dodgeforall <= DEF2) {
                    System.out.println("Уклонение за " + name2);
                } else {
                    System.out.println("Урон по персонажу " + name1 + " = " + (atkpers2 + atk));
                    HP1 = HP1 - (atkpers2 + atk);
                    System.out.println(HP1 + " Здоровья у Крестоносца");
                }
            }
            if (HP1 <= 0) {
                System.out.println("Крестоносец погиб");
                System.out.println("Очки решимости для " + name2 + " = " + (res1 + i) + ", Золото= " + (gold1 + 100 * i));

                return;
            } else if (HP2 <= 0) {
                System.out.println("Весталка погибла");
                System.out.println("Очки решимости для " + name1 + " = " + (res2 + i) + ", Золото= " + (gold2 + 100 * i));
                return;
            }

        }
    }
}
