package ss15_IO_binary_file_serialization.bai_tap.doc_file_csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "src/ss15_IO_binary_file_serialization/bai_tap/doc_file_csv/countries.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                List<String> country = parseCsvLine(line);
                printCountry(country);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + filePath);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }


    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null && !csvLine.isEmpty()) {
            String[] splitData = csvLine.split(",");
            for (String item : splitData) {
                result.add(item.trim());
            }
        }
        return result;
    }


    private static void printCountry(List<String> country) {
        if (country.size() >= 3) {
            System.out.println("Country [id= " + country.get(0)
                    + ", code= " + country.get(1)
                    + ", name= " + country.get(2) + "]");
        } else {
            System.out.println("⚠ Dòng không hợp lệ hoặc thiếu dữ liệu: " + country);
        }
    }
}
