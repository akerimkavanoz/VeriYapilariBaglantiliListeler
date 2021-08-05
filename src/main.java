import java.util.*;

public class main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Operations list = new Operations();  
        Operations list2 = new Operations(); 
        boolean a = true; 
        int counter = 0;
        int counter2 = 0;
        String previousEntry = " ";
       
        System.out.println("*******************************************************");
        System.out.println("                      İŞLEMLER                         ");
        System.out.println("undo: Son girdiyi listeden çıkarır\n"
                         + "redo: Yapılan son undo işlemini geri getirir\n"
                         + "yaz : Listeyi eklenme sırasına göre ekrana yazdırır\n"
                         + "  q : Programdan çıkış yapar ");
        System.out.println("*******************************************************");
        
        while(a)
        {
            System.out.print("Girdi: ");
            String entry = scanner.nextLine(); 
            
            if (entry.equals("q"))
            {
                a = false;
            }
            
            else if (entry.equals("undo")) 
            {   
                if (list.isFull()) 
                {
                    list2.addFirst(list.deleteEnd());
                }
                
                else
                {
                    System.out.println("Liste boş. Undo işlemi yapılamaz!");     
                }      
            }
            
            else if (entry.equals("redo")) 
            {     
                if(list2.isFull2())
                {                     
                    if (previousEntry.equals("undo") || (previousEntry.equals("redo") && counter < 5) || previousEntry.equals("yaz"))
                    { 
                        list.addEnd(list2.start2.entry);
                        list2.deleteFirst();  
                        
                        if (previousEntry.equals("redo") && entry.equals("redo") )
                        {
                            counter++;
                        }

                        else
                        {
                            counter = 1;
                        }
                    }
                    
                    else
                    {
                        System.out.println("Üst üste en fazla 5 kere redo işlemi yapabiirsiniz!");
                        
                    } 
                }
                
                else
                {   
                    if ( counter2 > 0 )
                    {
                        System.out.println("Listeye ekleme yapıldıktan sonra redo yapılamaz!");
                    }
                    
                    else
                    {
                        System.out.println("Undo işlemi yapılmadan redo yapılamaz!");
                    }   
                }
            }
            
            else if ( entry.equals("yaz")) 
            {  
                if (list.isFull())
                {
                    list.printList();
                }
                else
                {
                    System.out.println("Liste boş. Yazdırılacak veri yok!");
                }  
            }
            
            else if (entry.isEmpty())
            {
                System.out.println("Boş eleman girmezsiniz!");
            }
            
            else
            {
                list.addEnd(entry);
                list2.deleteAllList();
                counter2++;
            }
            
            if (!previousEntry.equals(entry))          
            {
                previousEntry = entry;     
            }    
        }
    }
}
