package projectCar;

public class Main {
    public static void main(String[] args) {
        // Проверяем, был ли передан аргумент командной строки
        String modelArgument = args.length > 0 ? args[0] : null; // Используем тернарный оператор для присваивания

        // Если аргумент передан, выводим модель
        if (modelArgument != null) {
            System.out.printf("Greetings! Model selected: %s%n", modelArgument);
        } else {
            System.out.println("Model argument not provided.");
        }

        // Печатаем числа от 1 до 5
        for (int num = 1; num <= 5; num++) {
            System.out.println("i = " + num);
        }
    }
}
