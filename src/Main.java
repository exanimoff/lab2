import java.io.*;
import java.time.LocalDateTime;
public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        System.out.print("Введите имя файла для чтения: ");
        try {
            filename = reader.readLine();
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("Файл не существует");
                return;
            }
            FileInputStream input = new FileInputStream(file);
            int c;
            int upperCount = 0;
            int lowerCount = 0;
            while ((c = input.read()) != -1) {
                char ch = (char) c;
                if (Character.isUpperCase(ch)) {
                    upperCount++;
                } else if (Character.isLowerCase(ch)) {
                    lowerCount++;
                }
            }
            input.close();
            String outputFilename;
            System.out.print("Введите имя файла для записи результатов: ");
            outputFilename = reader.readLine();
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilename, true)));
            String now = LocalDateTime.now().toString();
            writer.println("Количество больших букв: " + upperCount);
            writer.println("Количество маленьких букв: " + lowerCount);
            writer.println("Дата/время записи: " + now);
            writer.close();
            System.out.println("Результаты записаны в файл " + outputFilename);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}
