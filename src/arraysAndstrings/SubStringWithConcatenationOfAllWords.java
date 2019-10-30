package arraysAndstrings;

import java.util.*;

public class SubStringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rv = new ArrayList<>();
        if(s.length()==0 || words.length==0)
            return rv;
        
        int len=0;
        int[] freq = new int[26];
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String word: words){
            for(int i=0;i<word.length();++i){
                freq[word.charAt(i)-'a']++;
                ++len;
            }
            map.put(word,map.getOrDefault(word,0)+1);
        }
        
        int[][] arr = new int[s.length()+1][26];
        for(int i=1;i<=s.length();++i){
            for(int k=0;k<26;++k){
                arr[i][k]=arr[i-1][k];
            }
            arr[i][s.charAt(i-1)-'a']+=1;
        }
        
        for(int i=len;i<=arr.length;++i){
            boolean valid=true;
            for(int j=0;j<26;++j){
                if(arr[i][j]!=arr[i-len][j]+freq[j]){
                    valid=false;
                    break;
                }
            }
            if(valid){
                check(rv,map,s,i-len,i,words[0].length());
            }
        }
        return rv;
    }
    
    public void check(List<Integer> rv , HashMap<String , Integer> map , String s , int index,int limit,int len){
         HashMap<String,Integer> myMap = new HashMap<>();
        
        for(int i=index;i<limit;i+=len){
            String word=s.substring(i,i+len);
            System.out.println(word);
            myMap.put(word,myMap.getOrDefault(word,0)+1);
            if(myMap.get(word)>map.getOrDefault(word,0))
                return;
        }
        rv.add(index);
    }
    public static void main(String[] args) {
		String s=""
	}
}
