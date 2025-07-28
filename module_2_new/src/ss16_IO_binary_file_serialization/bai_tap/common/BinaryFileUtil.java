package ss16_IO_binary_file_serialization.bai_tap.common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BinaryFileUtil {
    public static <T> void writeToFile(String path, List<T> list) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.err.println("Lỗi ghi file nhị phân: " + e.getMessage());
        }
    }

    public static <T> List<T> readFromFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi đọc file nhị phân: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}