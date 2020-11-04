import javax.security.auth.kerberos.KerberosCredMessage;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.CheckedOutputStream;

public class Test {
    static ArrayList<String> arrayList=new ArrayList<>();
    static HashMap<Character,Integer> count=new HashMap<>();
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        int k = num.nextInt();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            if (str!="结束"){
                arrayList.add(str);
            }else {
                for (String s : arrayList) {
                    for (int i = 0; i < s.length(); i++) {
                        Character c = s.charAt(i);
                        if (count.containsKey(c)){
                            count.put(c,count.get(c)+1);
                        }else {
                            count.put(c,1);
                        }
                    }
                }
                List<Map.Entry<Character, Integer>> collect = count.entrySet().stream().sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue())).collect(Collectors.toList());
                for (int i = 0; i <k; i++) {
                    Map.Entry<Character, Integer> characterIntegerEntry = collect.get(i);
                    Character key = characterIntegerEntry.getKey();
                    Integer value = characterIntegerEntry.getValue();
                    System.out.println("字符："+key+"----出现次数是："+value);
                }

            }

        }
    }
}
