package exam;

import java.util.Stack;

public class ManajerUndo {
    private final Stack<Aksi> stack = new Stack<>();

    public void tambahAksi(Aksi aksi) {
        if (aksi == null) throw new IllegalArgumentException("aksi tidak boleh null");
        stack.push(aksi);
    }

    public Aksi batalkanAksi() {
        if (stack.isEmpty()) return null;
        return stack.pop();
    }

    public Aksi lihatAksiTerakhir() {
        if (stack.isEmpty()) return null;
        return stack.peek();
    }

    public boolean apakahKosong() {
        return stack.isEmpty();
    }
}
