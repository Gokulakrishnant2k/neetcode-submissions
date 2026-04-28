class Solution {

    public String encode(List<String> strs) {
        StringBuilder str=new StringBuilder();

        for(String s:strs){
            str.append(s.length()).append("#").append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list=new ArrayList<>();

        int i=0;

        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            
            int length=Integer.parseInt(str.substring(i,j));
            j++;

            String word=str.substring(j,j+length);
            list.add(word);
            i=j+length;
        }
        return list;

    }
}
