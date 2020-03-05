import java.util.Scanner;
public class assign{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n;
        int num[];
        num=new int[20];
        System.out.print("input n: ");
        n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.printf("num%d: ",i+1);
            num[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            System.out.printf("num%d:%d\n",i+1,num[i]);
        }
    }
}
