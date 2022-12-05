package bancoDeDados;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Dados {

    private static List<Conta> humanos = new LinkedList<>();
    private static int id = 1;

    public static List<Conta> humanos() {
        return humanos;
    }

    public static void moneytop() {
        humanos.sort((c1, c2) -> Double.compare(c2.getSaldo(), c1.getSaldo()));
    }
    
    public static void adiciona(Conta x) {
        x.setId(id++);
        x.setData(LocalDate.now());
        humanos.add(x);
    }

    public static void remove(Conta x) {
        humanos.remove(x);
    }

    public static Conta pesquisa(int id) {
        for (Conta x : humanos) {
            if (x.getId() == id) {
                return x;
            }
        }
        return null;
    }

    public static Conta pesquisa(String CPF) {
        for (Conta x : humanos) {
            if (x.getCpf().equals(CPF)) {
                return x;
            }
        }
        return null;
    }
}
