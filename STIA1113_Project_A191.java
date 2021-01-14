import java.util.Scanner;
public class STIA1113_Project_A191{
   static Scanner read = new Scanner (System.in);
   public static void main(String [] args)
   {
   String drivername[] = new String[100];
   String IC [] = new String[100];
   String exp [] = new String[100];
   String phone [] = new String[100];
   String status [] = new String[100];
   int choice;
   int count=0;
   do {
   menu();
   System.out.print("Your choice:"); 
   choice=Integer.parseInt(read.nextLine());
   if (choice==0){
    System.out.println("Thank you and Bye."); 
   break;
    }
   else
   count=processChoice(drivername,IC,exp,phone,status,choice,count);
   } while (choice !=0);
}//end main

static void menu(){
 System.out.println(":::::::: MENU :::::::::\n"
                   +"1. Add Item\n"
                   +"2. Edit Item\n"
                   +"3. Remove Item\n"
                   +"4. Display\n"
                   +"5. Search\n"
                   +"0. EXIT");
}//menu


static int processChoice(String [] drivername,String[]IC,String[]exp,String[]phone,String[]status,int choice,int count){
 switch(choice){
  case 1: count=addItem(drivername,IC,exp,phone,status,count); 
  System.err.print(count);break;
  case 2: editItem(drivername,IC,exp,phone,status,count); break;
  case 3: count=deleteItem(drivername,IC,exp,phone,status,count); break;
  case 4: display(drivername,IC,exp,phone,status,count); break;
  case 5: search(drivername,IC,exp,phone,status,count); break;
  default: System.out.println("Sorry your choice is not in the list. Please choose again.");
  }//switch
  return count;
}//processChoice

static void search(String [] drivername,String[]IC,String[]exp,String[]phone,String[]status,int count){
  String nom;
  boolean cari=false;
  if (count==0)
    System.out.println("Sorry list is empty.");
  else {
    System.out.print("Please enter driver name to search driver?:");
    nom=read.nextLine();
    for (int i=0; i<count;i++){
     if (drivername[i].equals(nom)){
      cari=true;
      System.out.println("Your search driver is at no."+(i+1)+" in the list.");
      break;
     }
    }
    if (cari==false)
     System.out.println("Sorry your search value is not in the list.");
   }    
  }//end search

static void display(String [] drivername,String[]IC,String[]exp,String[]phone,String[]status,int count){
     if (count==0)
          System.out.println("Sorry list is empty.");
     else{
      System.out.printf("E-Transport Management System (ETMS) %n"+
      "----------------------------------------------------------------------------------------------------%n");
      System.out.printf("%-5s%-20s%-35s%-20s%-20s%-20s%n",
         "No","Driver name:", "Identity card number:","Exprience:","Phone number:","Status:");
      for (int i=0; i<count;i++)
        System.out.printf("%-5s%-20s%-35s%-20s%-20s%-20s%n",
         (i+1),drivername[i], IC[i],exp[i],phone[i],status[i]);
         }  
}//end display

static void editItem(String [] drivername,String[]IC,String[]exp,String[]phone,String[]status,int count){
  String baru;
  boolean cari=false;
  if (count==0)
         System.out.println("Sorry list is empty.");
     else {
    System.out.print("Please enter the list number to edit: ");
    int i=Integer.parseInt(read.nextLine());
     --i;
    System.out.print("Please enter previous data?:");
    baru=read.nextLine();
    for (;i<count;){
     if (drivername[i].equals(baru)){
          System.out.print("New name?:");
          baru=read.nextLine();
          drivername[i]=baru;
          cari=true;
          break;
          }
     if (IC[i].equals(baru)){
          System.out.print("New identity card number?:");
          baru=read.nextLine();
          IC[i]=baru;
          cari=true;
          break;
          }
     if (exp[i].equals(baru)){
          System.out.print("New exprience?:");
          baru=read.nextLine();
          exp[i]=baru;
          cari=true;
          break;
          }
     if (phone[i].equals(baru)){
          System.out.print("New phone number?:");
          baru=read.nextLine();
          phone[i]=baru;
          cari=true;
          break;
          }
     if (status[i].equals(baru)){
          System.out.print("New status?:");
          baru=read.nextLine();
          status[i]=baru;
          cari=true;
          break;
          }

        }
        if (cari==false)
         System.out.println("Sorry your search value is not in the list.");
   }    
  }//end editItem*/

static int addItem(String [] drivername,String[]IC,String[]exp,String[]phone,String[]status,int count){
  if (count < drivername.length){
     System.out.println("Enter the name of driver:");
     drivername[count]= read.nextLine();
     System.out.println("Enter the identity card number of driver:");
     IC[count]= read.nextLine();
     System.out.println("Enter the experience of driver:");
     exp[count]= read.nextLine();
     System.out.println("Enter the phone number of driver:");
     phone[count]= read.nextLine();
     System.out.println("Enter the status of driver:");
     status[count]= read.nextLine();
  }
  else
    System.out.println("List is FULL.");
  return ++count;
}//addItem

static int deleteItem(String [] drivername,String[]IC,String[]exp,String[]phone,String[]status,int count){
   int i,j;
   String nom;
   int bil=count;
   boolean delete=false;
   if (bil==0)
     System.out.println("Sorry list is empty.");
  else {
  System.out.print("Driver name to be deleted?:");
  nom=read.nextLine();
  for ( i=0; i<bil;i++)
     if (drivername[i].equals(nom)){
        for(j=i;j<count-1;j++)
           drivername[j]=drivername[j+1];
         --bil;
         delete=true;
      break;
      }
    }
   if (delete==false)
   System.out.println("Sorry the data is not in the list.");
   return bil;
  }//end removeItem
 }//end class
