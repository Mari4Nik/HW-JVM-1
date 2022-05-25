public class JvmComprehension {
    // ClassLoader подгружает все необходимые системные классы в Metaspace и
    // загружает мета-данные класса JvmComprehension

    public static void main(String[] args) {
        // В момент вызова метода main создается фрейм в Stack

        int i = 1;                      // 1 В Stack во фрейм main помещается локальная переменная со своим значением
        Object o = new Object();        // 2 В куче выделяется память под объект Object, а ссылка o на созданный
        // объект в куче помещается в Stack во фрейм main

        Integer ii = 2;                 // 3 В куче выделяется память под объект Integer со значением 2,
        // а во фрейм main появляется переменная ii со ссылкой на созданный объект

        printAll(o, i, ii);             // 4 В Stack создаётся новый фрейм printAll(). И в нем помещаются:
        // ссылка o на ранее созданный Object в куче,
        // локальная переменная i = 1,
        // ссылка ii на ранее созданный Integer в куче.

        System.out.println("finished"); // 7 В Stack создаётся фрейм println, которому передается ссылка на созданный
        // в куче объект класса String со значением "finished"; в ходе работы программы отрабатывает Garbage collector.
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 В куче создается объект Integer со значением 700,
        // а ссылка uselessVar на созданный объект в куче помещается в Stack во фрейм printAll.

        System.out.println(o.toString() + i + ii);  // 6 В Stack создаётся новый фрейм println, в который
        // помещаются ссылки на объекты: (Object о, int i, Integer ii ). Фрейм toString создается в Stack, методы
        // вызываются для каждого из полей o, i и ii отдельно, и после выполнения удаляются из Stack .
    }
}
