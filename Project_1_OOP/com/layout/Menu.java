package com.layout;

import java.util.Scanner;

public class Menu {
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        while (choice != 0) {
            // TAMPILAN HALAMAN UTAMA
            System.out.println("-".repeat(24));
            System.out.println(" WELCOME TO CHICKEN SELLER DB");
            System.out.println("-".repeat(24));
            System.out.println("1.] Read Data");
            System.out.println("2.] Insert data");
            System.out.println("3.] Edit Data");
            System.out.println("4.] Delete data");
            System.out.println("0.] Keluar");
            System.out.println("-".repeat(24));
            System.out.print("Pilih: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    break;
                case 1: // MELIHAT DATA
                    ReadData.read();
                    break;
                case 2: // MENAMBAHKAN DATA
                    InsertData.insert();
                    break;
                case 3: // MENGUBAH DATA
                    EditData.edit();
                    break;
                case 4: // MENGHAPUS DATA
                    DeleteData.delete();
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
                    break;
            }
            System.out.println("-".repeat(24));
        }

        scanner.close();
    }
}

