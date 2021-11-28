import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LeetCode_811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> result = new HashMap<>();
        List<String> ans = new LinkedList();
        for(int i = 0;i<cpdomains.length;i++){
            String[] temp = cpdomains[i].split(" ");
            int num = Integer.parseInt(temp[0]);
            String[] domain =temp[1].split("\\.");
            String name="";
            for(int j = domain.length - 1; j >= 0; j--) {
                if(j == domain.length - 1) {
                    name = domain[j] + name;
                } else {
                    name = domain[j]+ "." + name;
                }
                int n = result.getOrDefault(name, 0) + num;
                result.put(name, n);
            }

        }
        for(Map.Entry<String, Integer> m : result.entrySet()){
            String str = m.getValue() + " " + m.getKey();
            ans.add(str);
        }
        return ans;
    }
    @Test
    public void demo(){
        String[] cpdomains = {"9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"};
        subdomainVisits(cpdomains);
    }
}
