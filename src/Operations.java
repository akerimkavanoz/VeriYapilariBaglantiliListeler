
public class Operations { 

    Interconnection start;
    Interconnection end;
    Interconnection start2;
    Interconnection end2;
    
    public Operations () 
    {
        start = null;
        end2 = null;
        start2 = null;
        end2 = null;
    }
     
    public boolean isFull() 
    {
        if ( start != null)
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }
    
    public boolean isFull2() 
    {
        if ( start2 != null)
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }
    
     public void addEnd ( String entry ) 
     {
        Interconnection newEntry = new Interconnection( entry );
       
        if ( isFull() )
        {
            end.next = newEntry;
            end = newEntry;
        }
        
        else
        {  
            start = newEntry;
            end = newEntry;
        }
    }
    
    public void addFirst ( String result ) 
    {
        Interconnection newEntry = new Interconnection( result );
        
        if ( isFull2() )
        {
            newEntry.next = start2;
            start2 = newEntry;
        }
        else
        {  
            start2 = newEntry;
            end2 = newEntry;
        }
    }
     
    public String deleteEnd() 
    {
        String result = "";
        
        if(isFull()) 
        {
            if ( start == end )
            {
                Interconnection deleted = end;
                result = deleted.entry;
                start = null;
                end = null;
            }
            
            else
            {
                Interconnection pointer = start;
                
                while ( pointer.next != end)
                {
                    pointer = pointer.next;
                }
                
                Interconnection deleted = end;
                result = deleted.entry;
                pointer.next = null;
                end = pointer;
            }       
        }
        return result;
    }

    public void deleteFirst() 
    {
        String result = "";
        
        if(isFull2()) 
        {
            if ( start2 == end2 )
            {
                start2 = null;
                end2 = null;
            }
            
            else
            {
                Interconnection newStart = start2.next; 
                Interconnection deleted = end2;
                result = deleted.entry;
                start2.next = null;
                start2 = newStart;
            }
        }
    }
    
    public void deleteAllList() 
    {
        Interconnection pointer = start2;
        int items = 0;
        
        while( pointer != null )
        {
            pointer = pointer.next;
            items++;
        }
        
        for(int i = 0; i < items; i++)
        {
            if(isFull2()) 
            {
                if ( start2 == end2 )
                {
                    start2 = null;
                    end2 = null;
                }
                
                else
                { 
                    pointer = start2;
                    
                    while ( pointer.next != end2)
                    {
                        pointer = pointer.next;
                    }
                    
                    pointer.next = null;
                    end2 = pointer;     
                }       
            }
        }     
    }
    
    public void printList() 
    {
        Interconnection pointer = start;
        int items = 0;
        System.out.print("\nList1 : ");
        
        while( pointer != null )
        {
            System.out.print(pointer.entry + " ");
            pointer = pointer.next;
            items++;
        }  
        System.out.println("\n");
    }
/*   
    public void printList2()     // Bu metot programı denerken kullanılmak için yazılmıştır.
    {
        Interconnection pointer = start2;
        int items = 0;
        System.out.print("\nList2 : ");
        
        while( pointer != null )
        {
            System.out.print(pointer.entry + " ");
            pointer = pointer.next;
            items++;
        }
        
        System.out.println();
        System.out.println("Eleman Sayısı: " + items);
        System.out.println();
    } 
*/
}