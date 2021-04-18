/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication114;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Hilal
 */
public class JavaApplication114 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int secim;
        while(true)
        {
            System.out.println("Elemanları Kendiniz Oluşturmak İstiyorsanız 1'e," + "\n" + "Elemanların Random Oluşturulmasını İstiyorsanız 2'ye Basınız.");
            Scanner deger = new Scanner(System.in);
            System.out.print("Giriş Yapınız : ");
            secim = deger.nextInt();
            if(secim != 1 && secim != 2)
            {
                System.out.println("Yanlış Bir Tuşa Bastınız. Programı Yeniden Başlatınız.");
                break;
            }
            else
            {
                switch(secim)
                {
                    case 1 : kendinOluştur();
                        break;
                    case 2 : randomOluştur();
                        break;
                }
            }
        }
    }
    
    private static void kendinOluştur() {
        double sayac = 0;
        double toplam = 0;
        double ort = 0;
        double varyans = 0;
        
        System.out.print("Eleman Sayısı Giriniz : ");
        Scanner deger = new Scanner(System.in);
        int v_sayisi = deger.nextInt();
        int dizi[] = new int[v_sayisi];
        
        for (int i = 0; i < dizi.length; i++) 
        {
            System.out.print((i+1) + ". Elemanı Giriniz : ");
            dizi[i] = deger.nextInt();
        }
        
        System.out.print("Oluşturduğunuz Elemanlar : ");
        for (int i = 0; i < dizi.length; i++)
        {
            System.out.print(dizi[i] + " ");
            sayac++;
            toplam += dizi[i];
            ort = toplam / sayac;
        }
      
        System.out.println("\n" + "Toplam Eleman Sayısı : " + sayac + "\n" + "Toplam : " + toplam + "\n" + "Ortalama : " + ort);
        
        JavaApplication114 standartSapma = new JavaApplication114();
        standartSapma.iteratifBul(dizi, sayac, ort);
        //standartSapma.recursiveBul(dizi, sayac, ort);
        System.out.println("Standart Sapma İteratif Sonucu : " + standartSapma.iteratifBul(dizi, sayac, ort));
        System.out.println("Standart Sapma Rekürsif Sonucu : " + standartSapma.recursiveBul(dizi, sayac, ort));
    }
    
    private static void randomOluştur() 
    {
        double sayac = 0;
        double toplam = 0;
        double ort = 0;
        double varyans = 0;
        
        System.out.print("Eleman Sayısı Giriniz : ");
        Scanner deger = new Scanner(System.in);
        int v_sayisi = deger.nextInt();
        int dizi[] = new int[v_sayisi];
        
        Random uret = new Random();
        for (int i = 0; i < dizi.length; i++) 
        {
            dizi[i] = uret.nextInt(100);
        }
        
        System.out.print("Oluşturulan Elemanlar : ");
        for (int i = 0; i < dizi.length; i++)
        {
            System.out.print(dizi[i] + " ");
            sayac++;
            toplam += dizi[i];
            ort = toplam / sayac;
        }
        
        System.out.println("\n" + "Toplam Eleman Sayısı : " + sayac + "\n" + "Toplam : " + toplam + "\n" + "Ortalama : " + ort);
        
        JavaApplication114 standartSapma = new JavaApplication114();
        standartSapma.iteratifBul(dizi, sayac, ort);
        //standartSapma.recursiveBul(dizi, sayac, ort);
        System.out.println("Standart Sapma İteratif Sonucu : " + standartSapma.iteratifBul(dizi, sayac, ort));
        System.out.println("Standart Sapma Rekürsif Sonucu : " + standartSapma.recursiveBul(dizi, sayac, ort));
    }
    
    private double iteratifBul(int[] dizi, double sayac, double ort)
    {
        double varyans = 0;
        for (int i = 0; i < dizi.length; i++)
        {
            varyans += ((dizi[i] - ort) * (dizi[i] - ort)) / (sayac - 1);
        }
        System.out.println("Varyans : " + varyans);
        double s_sapma = Math.pow(varyans, (0.5));
        return s_sapma;
    }
    
    private double recursiveBul(int[] dizi, double ort, double sayac)
    {
        if (sayac == 0)
        {
            return dizi[0];
        }
        else
        {
            return (Math.pow((dizi[(int)(sayac) - 1] - ort)*(dizi[(int)(sayac) - 1] - ort)/ (sayac - 1), (0.5))) + recursiveBul((sayac - 1), dizi, ort);
//                return Math.pow(((dizi[sayac] - ort) * (dizi[sayac] - ort) / (sayac - 1)), (0.5)) +  recursiveBul Math.pow(((dizi[sayac - 1] - ort) * (dizi[sayac - 1] - ort) / (sayac - 1)), (0.5));
        }
    }
}