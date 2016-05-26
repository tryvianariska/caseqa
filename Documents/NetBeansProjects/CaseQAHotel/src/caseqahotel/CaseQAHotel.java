/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caseqahotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author owner
 */
public class CaseQAHotel {

    static ArrayList<Hotel> listHotel = new ArrayList<>();
    static String[] lokasi = new String[]{"jakarta", "surabaya", "depok", "bandung", "jogjakarta", "solo", "padang", "bekasi", "tangerang", "bogor"};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Mau pesan hotel di mana? : ");

            generateList();
            String baca = in.readLine();
            String kota = "";
            for (String lokasi1 : lokasi) {
                if (baca.toLowerCase().contains(lokasi1)) {
                    kota = lokasi1;
                }
            }
            if (!kota.equals("")) {
                ArrayList<String> hasilPencarian = new ArrayList<>();
                for (int i = 0; i < listHotel.size(); i++) {
                    if (kota.equals(listHotel.get(i).getLokasi())) {
                        hasilPencarian.add(listHotel.get(i).nama);
                    }
                }
                String jawaban = "Kamu bisa pesan hotel di ";
                for (int i = 0; i < hasilPencarian.size(); i++) {
                    if (i == hasilPencarian.size() - 1) {
                        jawaban += "Hotel " + hasilPencarian.get(i);
                    } else {
                        jawaban += "Hotel " + hasilPencarian.get(i) + " atau ";
                    }
                }
                System.out.println(jawaban + " di kota " + kota);
                System.out.println("===========================================================");
                System.out.println("Cari lagi? [y/n]");
                String cari = in.readLine();
                
                if (cari.contains("n")){
                    break;
                }
            } else {
                System.out.println("Ups! Sepertinya kami belum memiliki data di kota tersebut :\\(");
                System.out.println("===========================================================");
                System.out.println("Cari kota yang lain? [y/n]");
                String cari = in.readLine();
                
                if (cari.contains("n")){
                    break;
                }
            }
        }
    }

    public static void generateList() {
        String A = " AAA";
        String B = " BBB";

        int n = 0;
        for (int i = 0; i < lokasi.length * 2; i++) {

            if (i % 2 == 0) {
                //System.out.println(lokasi[i]);
                Hotel hotel = new Hotel(lokasi[n], A + i);
                listHotel.add(hotel);

            } else {
                // System.out.println(lokasi[i]);
                Hotel hotel = new Hotel(lokasi[n], B + i);
                listHotel.add(hotel);
                n++;

            }

        }

    }

}
