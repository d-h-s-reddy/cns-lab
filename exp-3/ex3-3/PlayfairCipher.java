import java.util.*;
class PlayfairCipher{
    public static void main(String[] args) throws Exception {
        //Scanner s=new Scanner(System.in);
        System.out.println("Enter the plaintext:");
        String plaintext="hari";
        System.out.println("Enter the key:");
        String key="apple";
        //now we should remove the duplicates of the key
        key=removeduplicates(key);

    }

    private static String removeduplicates(String key) {
        char c[]=key.toCharArray();
        String newkey="";
        for(int i=0;i<key.length();i++){
            for(int j=0;j<key.length();j++){
                if(key.charAt(i)==key.charAt(j)){
                    c[j]='1';
                }
            }
        }
        for(int i=0;i<c.length;i++){
            if(c[i]=='1'){
                continue;
            }
            else{
                newkey+=c[i];
            }
        }
        System.out.println("The new key is"+newkey);
        return newkey;
    }
}