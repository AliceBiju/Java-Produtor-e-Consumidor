import java.util.ArrayList;
import java.util.List;

public class SharedList {
    private List<Integer> list = new ArrayList<>();
    private final int MAX_SIZE = 10;

    public synchronized void addValue(int value) {
        // Região crítica: Adicionando um valor à lista
        while (list.size() == MAX_SIZE) {
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        list.add(value);
        System.out.println("T1: Valor " + value + " adicionado.");
        notify();  
    }

    public synchronized int consumeValue() {
        // Região crítica: Consumindo um valor da lista
        while (list.isEmpty()) {
            try {
                wait();  
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int value = list.remove(0);
        System.out.println("T2: Valor " + value + " consumido.");
        notify();  
        return value;
    }
}
