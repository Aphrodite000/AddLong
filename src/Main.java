import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String addend=s.nextLine();
        String augend=s.nextLine();
        String result=AddLongInteger(addend,augend);
        System.out.println(result);
    }
    public static String AddLongInteger(String addend,String augend){
        int max=Math.max(addend.length(),augend.length());
        StringBuilder sp=new StringBuilder();
        int zer0=max-addend.length();
        for(int t=0;t<=zer0-1;t++){
            sp.append("0");
        }
        for(int i=0;i<addend.length();i++){
            sp.append(addend.charAt(i));
        }
        System.out.println(sp);
        int[] a=new int[max];
        for(int i=0;i<max;i++){
            a[i]=sp.charAt(i)-48;
            //System.out.println(sp);
        }
        System.out.println(Arrays.toString(a));

        StringBuilder sq=new StringBuilder();
        int zer1=max-augend.length();
        for(int t=0;t<=zer1-1;t++){
            sq.append('0');
        }
        for(int i=0;i<augend.length();i++){
            sq.append(augend.charAt(i));
        }
        int[] b=new int[max];
        int j;
        for(int i=0;i<max;i++){
            b[i]=sq.charAt(i)-48;
        }
        System.out.println(Arrays.toString(b));
        int[] c=new int[max+1];
        //temp为进位
        int temp=0;
        for(int i=max;i>=1;i--){
            c[i]=(a[i-1]+b[i-1])%10+temp;
            temp=0;
            temp=(a[i-1]+b[i-1])/10;
        }
        //最高位是否有进位
        if(temp!=0){
            c[0]=temp;
            //数组转字符串
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<max+1;i++){
                sb.append(c[i]);
            }
            String re=sb.toString();
            return re;
        }
        StringBuilder sc=new StringBuilder();
        for(int i=1;i<max+1;i++){
            sc.append(c[i]);
        }
        String re=sc.toString();
        return re;
    }
}
