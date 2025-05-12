package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static <T> void saveToFile(List<T> lista, String arquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        } catch (Exception e) {
            System.err.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static <T> List<T> loadFromFile(String arquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<T>) ois.readObject();
        } catch (Exception e) {
            System.err.println("Erro ao carregar arquivo: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}