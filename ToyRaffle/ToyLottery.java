package ToyRaffle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.text.BreakIterator;
import java.io.BufferedReader;
import java.io.FileReader;

public class ToyLottery {
    private List<Toy> listToys = new ArrayList<>();
    private int toyCount;

    public List<Toy> getToys() {
        return listToys;
    }

    public int getToyCount() {
        System.out.println(toyCount + " игрушек");
        return toyCount;
    }

    // Розыгрыш с регулируемым шансом на победу
    // если выигрыш, то записываем имя игрушки в файл
    // и удаляем её из списка разыгрываемых игрушек
    public int lotteryToy() {
        Scanner scan = new Scanner(System.in);
        int chance = 50;
        System.out.println("Шанс на выигрыш по умолчанию: 50%");
        System.out.println("Если хотите изменить шанс на выигрыш, нажмите 1");
        System.out.println("Если хотите оставить шанс на выигрыш по умолчанию, нажмите 2");
        String changeСhance = scan.next();
        if (changeСhance.equals("1")) {
            System.out.println("Введите желаемый шанс на выигрыш в % (от 0 до 100): ");
            chance = scan.nextInt();
        }
        if (chance >= 0 && chance <= 100) {
            Random rnd = new Random();
            int num = rnd.nextInt(100);
            if (num > chance) {
                System.out.println("Вы проиграли, попробуйте cнова");
            } else if (num < chance) {
                int whatToy = rnd.nextInt(listToys.size());
                System.out.println("Поздравляю, вы выиграли!");
                System.out.println("Ваш приз: " + listToys.get(whatToy).getToyName());
                saveInFile(whatToy);
                deleteToyFromListToys(whatToy);
                return whatToy;
            }
        } else {
            System.out.println("Вы ввели неверное значение! Попробуйте еще раз");
        }
        return chance;
    }

        // Добавить игрушку в розыгрыш
        public List<Toy> addToyInListToys(Toy name) {
            listToys.add(name);
            toyCount++;
            return listToys;
        }
    
        // Удалить игрушку из списка по номеру id
        private List<Toy> deleteToyFromListToys(int id) {
            listToys.remove(id);
            toyCount--;
            return listToys;
        }
    
        // Запись выигрышных игрушек в файл ".txt"
        public void saveInFile(int whatToy) {
            try (FileWriter writer = new FileWriter("WinningToys.txt", true)) {
                String text = listToys.get(whatToy).getToyName();
                writer.write(text + "\n");
                writer.close();
            } catch (Exception ex) {
                System.out.println("Ошибка записи файла");
            }
        }
    
        // Чтение файла с выигранными игрушками
        public void readFile() {
            try {
                FileReader fr = new FileReader("WinningToys.txt");
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                if (line != null) {
                    System.out.println("Выигранные ирушки:");
                }
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }
    
            } catch (Exception ex) {
                System.out.println("Ошибка чтения файла");
            }
        }
}
