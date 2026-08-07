class Solution { 
 char special = '#';

    public String encode(List<String> strs) {
        StringBuilder strb = new StringBuilder();
        for (String str : strs) {
            strb.append(str.length()).append(special).append(str);
        }
                System.out.println( " encode: " + strb.toString());

        return strb.toString();
    }


    public List<String> decode(String str) {

        if(str.length()==2) return List.of("");
        List<String> strs= new ArrayList<>();
        System.out.println( " decode: " + str);

        for (int i = 0; i < str.length();) {
            int numStart = i;
            while (special != str.charAt(i)) {
                i++;
            }
            System.out.println( " numStart: " + numStart+ " numEnd:"+i);

            int count = Integer.parseInt(str.substring(numStart, i++));
            System.out.println( " count: " + count);
            String strss=str.substring(i, i+count);
            System.out.println( " strss: " + strss);
            strs.add(strss);
  i += count;        }
        return strs;
    }

}
