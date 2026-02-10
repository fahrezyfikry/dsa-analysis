package exam;

public class UndoRedoMain {
	public static void main(String[] args) {
		ManajerUndo manager = new ManajerUndo();

		manager.tambahAksi(new Aksi("Ketik 'Halo dunia'"));
		manager.tambahAksi(new Aksi("Bold teks pada paragraf 1"));
		manager.tambahAksi(new Aksi("Hapus baris ke-3"));

		System.out.println("Aksi terakhir: " + manager.lihatAksiTerakhir());

		System.out.println("\nMulai membatalkan aksi satu per satu:");
		while (!manager.apakahKosong()) {
			Aksi a = manager.batalkanAksi();
			System.out.println("Membatalkan: " + a);
		}

		Aksi coba = manager.batalkanAksi();
		System.out.println("\nMencoba batalkan lagi: " + (coba == null ? "Tidak ada aksi yang bisa dibatalkan." : coba));
	}
}
