import java.util.Scanner;

class Mahasiswa {
    String nim;
    String name;
    String major;
    Mahasiswa next;

    Mahasiswa(String nim, String name, String major) {
        this.nim = nim;
        this.name = name;
        this.major = major;
        this.next = null;
    }
}

class LinkedListMahasiswa {
    Mahasiswa head;
    int jumlahData;

    LinkedListMahasiswa() {
        head = null;
        jumlahData = 0;
    }

    boolean push(String nim, String name, String major) {
        if (jumlahData >= 5) {
            System.out.println("Maaf, data sudah penuh! Maksimal 5 data.");
            return false;
        }

        Mahasiswa newNode = new Mahasiswa(nim, name, major);

        if (head == null) {
            head = newNode;
        } else {
            Mahasiswa current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        jumlahData++;
        System.out.println("Data mahasiswa berhasil ditambahkan!");
        return true;
    }

    void showAllData() {
        if (head == null) {
            System.out.println("Data mahasiswa kosong!");
            return;
        }

        sortByNim();

        String frame = "";
        String separator = "";
        String space = "";
        for (int i = 0; i < 92; i++) {
            frame += "=";
            separator += "-";
        }
        for (int i = 0; i < 34; i++) {
            space += " ";
        }

        System.out.println("\n" + frame);
        System.out.println(space + "DAFTAR DATA MAHASISWA");
        System.out.println(frame);
        System.out.printf("%-12s %-30s %-50s%n", "NIM", "NAMA", "JURUSAN");
        System.out.println(separator);

        Mahasiswa current = head;
        int nomor = 1;
        while (current != null) {
            System.out.printf("%-12s %-30s %-50s%n", current.nim, current.name, current.major);
            current = current.next;
            nomor++;
        }
        System.out.println(frame);
        System.out.println("Total data: " + jumlahData + " mahasiswa");
    }

    void sortByNim() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Mahasiswa current = head;
            Mahasiswa prev = null;

            while (current.next != null) {
                if (current.nim.compareTo(current.next.nim) > 0) {
                    String tempNim = current.nim;
                    String tempName = current.name;
                    String tempMajor = current.major;

                    current.nim = current.next.nim;
                    current.name = current.next.name;
                    current.major = current.next.major;

                    current.next.nim = tempNim;
                    current.next.name = tempName;
                    current.next.major = tempMajor;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    void popAllData() {
        if (head == null) {
            System.out.println("Data sudah kosong!");
            return;
        }

        System.out.println("\nMenghapus semua data mahasiswa...");
        while (head != null) {
            System.out.println("Pop: " + head.nim + " - " + head.name);
            head = head.next;
            jumlahData--;
        }
        System.out.println("Semua data mahasiswa berhasil dihapus!");
    }
}

public class College {
    static Scanner scanner = new Scanner(System.in);
    static LinkedListMahasiswa list = new LinkedListMahasiswa();

    public static void main(String[] args) {
        int option;

        do {
            showMenu();
            option = inputOption();

            switch (option) {
                case 1:
                    pushDataMahasiswa();
                    break;
                case 2:
                    list.showAllData();
                    break;
                case 3:
                    list.popAllData();
                    break;
                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-4.");
            }
            System.out.println();
        } while (option != 4);

        scanner.close();
    }

    static void showMenu() {
        System.out.println("========================================");
        System.out.println("   SISTEM MANAJEMEN DATA MAHASISWA");
        System.out.println("      (Single Linked List)");
        System.out.println("========================================");
        System.out.println("1. Push Data Mahasiswa");
        System.out.println("2. Tampilkan Semua Data Mahasiswa");
        System.out.println("3. Pop Semua Data Mahasiswa");
        System.out.println("4. Keluar");
        System.out.println("========================================");
    }

    static int inputOption() {
        System.out.print("Pilih menu (1-4): ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    static void pushDataMahasiswa() {
        if (list.jumlahData >= 5) {
            System.out.println("Maaf, data sudah penuh! Maksimal 5 data.");
            return;
        }

        String nim, name, major;

        do {
            System.out.print("Masukkan NIM (maksimal 10 angka): ");
            nim = scanner.nextLine();
            if (nim.isEmpty()) {
                System.out.println("NIM tidak boleh kosong!");
            } else if (nim.length() > 10) {
                System.out.println("NIM maksimal 10 angka!");
            } else if (!nim.matches("[0-9]+")) {
                System.out.println("NIM harus berupa angka!");
            }
        } while (nim.isEmpty() || nim.length() > 10 || !nim.matches("[0-9]+"));

        do {
            System.out.print("Masukkan Nama (maksimal 30 karakter): ");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Nama tidak boleh kosong!");
            } else if (name.length() > 30) {
                System.out.println("Nama maksimal 30 karakter!");
            }
        } while (name.isEmpty() || name.length() > 30);

        do {
            System.out.print("Masukkan Jurusan (maksimal 50 karakter): ");
            major = scanner.nextLine();
            if (major.isEmpty()) {
                System.out.println("Jurusan tidak boleh kosong!");
            } else if (major.length() > 50) {
                System.out.println("Jurusan maksimal 50 karakter!");
            }
        } while (major.isEmpty() || major.length() > 50);

        list.push(nim, name, major);
    }
}
