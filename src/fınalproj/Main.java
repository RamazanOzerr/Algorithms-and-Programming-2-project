package fınalproj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
            // GEREKLİ DEGISKENLERI ATIYORUZ
		DoublyLinkedList lld = new DoublyLinkedList();
                lld=dosyaOkuma();      
                Scanner scan = new Scanner(System.in);
                int islemTur = 5;
                
                
                
                while(islemTur != 0){ // 0 girilince programı kapatır
                    menu();
                    islemTur = scan.nextInt();
                    switch(islemTur){
                        case 1: // ekleme yapar
                            System.out.println("!!ÖĞRENCİ BİLGİLERİ GİRİLİRKEN VİRGÜLDEN SONRA BOŞLUK BIRAKILMAYACAĞI VARSAYILMIŞTIR!!");
                            System.out.print("Eklemek istediğiniz öğrencinin bilgilerini giriniz");
                            System.out.print("(Okul numarası,isim,tel no) :");
                            
                            
                            scan.nextLine();
                            String studInfo = scan.nextLine();                       
                            Student s = new Student();
                            s = cumleBol(studInfo);
                            lld.InsertHere(s);
                            break;
                        
                        case 2: // silme yapar
                            System.out.print("Silmek istediğiniz öğrencinin numarasını giriniz:");
                            int deletedStudNum = scan.nextInt(); // silinecek ogrencinin numarasını istiyoruz
                            lld.deleteStudents(deletedStudNum);
                            System.out.println("öğrenci siliniyor...");
                            break;
                        
                        case 3: // arama yapar
                            System.out.print("Aramak istediğiniz öğrencinin adını giriniz:");
                            scan.nextLine(); // ogrenci ismini alıyoruz
                            String name = scan.nextLine();
                            System.out.println("Öğrenci aranıyor...");
                            lld.searchStudents(name);
                            break;
                        
                        case 4: // küçükten büyüğe sıralı sekilde display eder
                            lld.printlist();
                            break;
                        
                        case 5:  // büyükten küçüğe sıralı şekilde display eder
                            lld.reversePrintList();
                            break;       
                    }
                    System.out.println(" ");
                    
                   
                }
                System.out.println("Program kapatılıyor...");
                
               
	}
        // GÖNDERDİGİMİZ CUMLEYİ STUDENT ICIN BOLEN VE BIR STUDENTA ATAYAN BİR METHOD
        public static Student cumleBol(String cumle) {
		
		//telefon numaralarının tutulacagı arraylist
		ArrayList<String> phoneNumbers = new ArrayList<String>();
		Student s1 = new Student();
		
		// ogrencı verilerini "," ile ayırıp bir listeye ekliyoruz
		String[] student_Informations = cumle.split(",");
		
		// ogrenci verilerinin 2. indeksinden buyukler telefon numarası oldugunda onları phoneNumbers listesine ekliyoruz
		for (int i = 0; i<student_Informations.length;i++){
			if (i>=2) {
				phoneNumbers.add(student_Informations[i]); // ogrenci numarasını burda bir listeye atıyoruz
			}
		}
		
		// OGRENCI'YI ATIYORUZ
		s1.setAdSoyad(student_Informations[1]);
		s1.setOgrenci_No(Integer.parseInt(student_Informations[0]));
		s1.setPhone_numbers(phoneNumbers);
		
		return s1;
		
	}
        // DOSYA OKUMA VE BUNU LİNKEDLİSTE ATAN METHOD
        public static DoublyLinkedList dosyaOkuma() {
		DoublyLinkedList lld = new DoublyLinkedList();
		Student s1 = null;
		
		try {
			File myobj = new File("Student.txt");
			Scanner myReader = new Scanner(myobj); 
			while(myReader.hasNextLine()) 
				{
				String newst = myReader.nextLine();
				
				s1= cumleBol(newst);
				lld.InsertHere(s1);
				
			}
			myReader.close(); // MYREADER KAPATIYORUZ
		}catch(FileNotFoundException e) {
			System.out.println("Dosya Bulunamadı");
			e.printStackTrace();
		}
		return lld;
	}

        public static void menu(){
                System.out.println("0- Programdan çıkış");
                System.out.println("1- Öğrenci ekleme");
                System.out.println("2- Öğrenci silme");
                System.out.println("3- Öğrenci arama");
                System.out.println("4- Listeyi küçükten büyüğe yazdırma");
                System.out.println("5- Listeyi büyükten küçüğe yazdırma");
                System.out.print("Yapmak istediğiniz işlem türünü giriniz:");
        }

}

