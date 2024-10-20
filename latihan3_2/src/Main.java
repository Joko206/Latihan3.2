import java.util.Scanner;

// Kelas Passenger untuk merepresentasikan seorang penumpang
class Passenger {
    String nama;
    Passenger berikutnya;

    Passenger(String nama) {
        this.nama = nama;
        this.berikutnya = null;
    }
}

// Kelas Flight untuk mengelola daftar penumpang
class Flight {
    private Passenger kepala;
    private Scanner input;

    // Konstruktor
    public Flight() {
        kepala = null;
        input = new Scanner(System.in);
    }

    // Menambahkan penumpang baru ke akhir daftar
    public void tambahPenumpang() {
        System.out.print("Masukkan nama penumpang: ");
        String nama = input.nextLine();

        Passenger penumpangBaru = new Passenger(nama);

        if (kepala == null) {
            kepala = penumpangBaru;
        } else {
            Passenger current = kepala;
            while (current.berikutnya != null) {
                current = current.berikutnya;
            }
            current.berikutnya = penumpangBaru;
        }

        System.out.println(nama + " telah ditambahkan ke daftar penumpang.");
    }

    // Menghapus penumpang dari daftar berdasarkan nama
    public void hapusPenumpang() {
        if (kepala == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        System.out.print("Masukkan nama penumpang yang akan dihapus: ");
        String nama = input.nextLine();

        if (kepala.nama.equals(nama)) {
            kepala = kepala.berikutnya;
            System.out.println(nama + " telah dihapus dari daftar penumpang.");
            return;
        }

        Passenger sebelumnya = kepala;
        Passenger current = kepala.berikutnya;

        while (current != null) {
            if (current.nama.equals(nama)) {
                sebelumnya.berikutnya = current.berikutnya;
                System.out.println(nama + " telah dihapus dari daftar penumpang.");
                return;
            }
            sebelumnya = current;
            current = current.berikutnya;
        }

        System.out.println(nama + " tidak ditemukan dalam daftar penumpang.");
    }

    // Menampilkan semua penumpang
    public void tampilkanPenumpang() {
        if (kepala == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        System.out.println("Daftar Penumpang:");
        Passenger current = kepala;
        int nomor = 1;

        while (current != null) {
            System.out.println(nomor + ". " + current.nama);
            current = current.berikutnya;
            nomor++;
        }
    }
}

// Kelas Main untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        Flight penerbangan = new Flight();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Penumpang");
            System.out.println("2. Hapus Penumpang");
            System.out.println("3. Tampilkan Daftar Penumpang");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline yang tersisa

            switch (pilihan) {
                case 1:
                    penerbangan.tambahPenumpang();
                    break;
                case 2:
                    penerbangan.hapusPenumpang();
                    break;
                case 3:
                    penerbangan.tampilkanPenumpang();
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 4);

        scanner.close(); // Menutup scanner
    }
}