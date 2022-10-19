package fınalproj;

public class DoublyLinkedList {

	static Node head;
	static Node tail;
	
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}
	
	//LISTEYE SIRALI BI SEKILDE ELEMAN EKLER, KUCUKTEN BUYUGE OLACAK SEKILDE
        public void InsertHere(Student s1) {
		Node p = new Node();
		p.setItem(s1);
		p.nextNode = null;
		
                // LISTE NULL SA BU BLOK CALISIR
		if ( head == null) {
			head = p;
			tail = p;
			head.previous = null;
			return;
		}
		
                if(p.getItem().getOgrenci_No()==head.getItem().getOgrenci_No()|| p.getItem().getOgrenci_No()==tail.getItem().getOgrenci_No()){
                    System.out.println("Bu numaralı öğrenci sistemde zaten mevcut!!");
                    return;
                }
                
		// GELEN ELEMANIN NO'SU HEADDINKINDEN KUCUK ISE BURASI CALISIR
                // YENİ ELEMAN HEAD OLUR
                if(p.getItem().getOgrenci_No()<head.getItem().getOgrenci_No()) {
			p.previous = null;
			head.previous = p;
			p.nextNode = head;
			head = p;
			return;
			
		}
	
                // YENI ELEMANIN NO'SU TAİLINKINDEN BUYUKSE BURASI CALISIR
                // YENİ ELEMAN TAİL OLUR
		if(p.getItem().getOgrenci_No()>tail.getItem().getOgrenci_No()) {
			p.previous = tail;
			tail.nextNode = p;
			tail = p;
			return;
		}
		
		// ORTALARA ELEMAN EKLENECEGĞİ ZAMAN GEÇİCİ BİR NODE TANIMLIYORUZ
		Node temp = head.nextNode;
		
                // GECICI NODE UN NOSU BİZİM ELEMANIN NOSUNDAN BUYUK OLUNCAYA KADAR BURASI CALISIR
                 
		while(temp.getItem().getOgrenci_No()<p.getItem().getOgrenci_No()) {
			temp = temp.nextNode;
			 //dsadsa
		}
                // GECICI NODUN NOSU BUYUK OLDUGUNDA TEMPIN ONCESİNE EKLER
		temp.previous.nextNode = p; // tempın previousunun nexti ile p yi birleştirir
		p.previous = temp.previous; // p'nın previousu le tempin previousunu yi birleştirir
		temp.previous  = p;// tempın previousunu ile p yi birleştirir
		p.nextNode = temp;// p'nin nextini temp ile birleştirir
	
                if(temp.getItem().getOgrenci_No()  == p.getItem().getOgrenci_No()){
                    System.out.println("Bu numaralı öğrenci sistemde zaten mevcut!!");
                }
		
	} 
	
	// LISTEYI KUCUKTEN BUYUGE EKRANA YAZAN METHOD
	static void printlist() {
            System.out.println("");
            Node temp = new Node();
            temp = head;
            // temp null deilse burası calısır
		while (temp!=null) {	
			System.out.println(temp.getItem());
			temp=temp.nextNode;
			}
	}
	
        // LISTEYI BUYUKTEN KUCUGE EKRANA YAZAN METHOD
	static void reversePrintList() {
            System.out.println("");
            Node temp =new Node();
            temp = tail;
            // temp null degilse bu blok calisir
		while (temp!=null) {
			System.out.println(temp.getItem());
			temp=temp.previous;
			}
	}
	
        // PARAMETRE OLARAK GELEN OGRENCI ISMINI ARAYIP BULAN VE EKRANA YAZDIRAN METHOD
	public void searchStudents(String name) {
		Node temp = head;
	        while (temp!=null) {
			if(temp.item.getAdSoyad().equals(name)) {
				System.out.println(temp.getItem());
			}
				temp = temp.nextNode;
		}
	
        }
        
        // PARAMETRE OLARAK OGRENCI NUMARASI GELEN OGRENCIYI SILEN METHOD
	public void deleteStudents(int student_number) {
                // gecıcı bır node tanımlıyoruz bunu ilk basta heade esitliyoruz
		Node temp= head;
                // tempin numarası ile parametre aynı oluncaya kadar calısır
                 while(temp!=null && temp.getItem().getOgrenci_No()!=student_number) {
			temp = temp.nextNode;
		}
                 // while dan cıktıgında temp aradıgımız ogrencidir
                 // temp ile head aynı ise bu blok calısır
		if (temp==head){
                    //linkedlist takas islemi
			head.nextNode.previous = null; 
			head = head.nextNode;
			temp = null;
                 }
                //temp ile tail aynı ise bu blok calısır
                else if(temp == tail && temp.previous != null){
                    //linkedlist takas islemi
                    tail.previous.nextNode = null;
                    tail = tail.previous;
                    temp = null;
                }
                // eger temp ortadan bir ogrenci ile aynı ise bu blok calısır
                else{
                    //linkedlist takas islemi
                    temp.previous.nextNode = temp.nextNode;
                    temp.nextNode.previous = temp.previous;
                    temp = null;
	
        }
    }
}