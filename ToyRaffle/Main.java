package ToyRaffle;

public class Main {
    public static void main(String[] args) {
        // Создание объектов "Игрушки"
        Toy bear = new Toy(1, "Bear");
        Toy car = new Toy(2, "Car");
        Toy cubes = new Toy(3, "Cubes");
        Toy lego = new Toy(4, "Lego");
        Toy balloons = new Toy(5, "Balloons");
        Toy ball = new Toy(6, "Ball");
        Toy sword = new Toy(7, "Sword");

        // Создание объекта "Розыгрыш игрушек" с добавлением игрушек в розыгрыш
        ToyLottery toyLottery = new ToyLottery();
        toyLottery.addToyInListToys(bear);
        toyLottery.addToyInListToys(car);
        toyLottery.addToyInListToys(cubes);
        toyLottery.addToyInListToys(lego);
        toyLottery.addToyInListToys(balloons);
        toyLottery.addToyInListToys(ball);
        toyLottery.addToyInListToys(sword);

        // Запускаем розыгрыш с управлением выпадения выигрыша, затем читаем файл
        toyLottery.lotteryToy();
        toyLottery.readFile();
        toyLottery.lotteryToy();
        toyLottery.readFile();

        // Проверяем оставшиеся игрушки в списке
        System.out.println("В розыгрыше оставлись:");
        toyLottery.getToys();

        // просматриваем число игрушек в списке
        toyLottery.getToyCount();
    }
}
