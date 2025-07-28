package ss15_text_file.bai_tap.copy_file_text;

import java.io.*;

public class Main {

    private static void copyFileText(String source, String target) {

        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Sao chép file thành công!");

        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file nguồn: " + source);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi sao chép file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String sourceFile = "src/ss15_text_file/bai_tap/copy_file_text/source.csv";
        String targetFile = "src/ss15_text_file/bai_tap/copy_file_text/target.csv";

        copyFileText(sourceFile, targetFile);
    }
}
