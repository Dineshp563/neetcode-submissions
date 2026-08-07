class Solution { 
 char special = '#';

    public String encode(List<String> strs) {
        StringBuilder strb = new StringBuilder();
        for (String str : strs) {
            strb.append(str.length()).append(special).append(str);
        }
 
        return strb.toString();
    }


    public List<String> decode(String str) {

        if (str.length() == 2) return List.of("");
        List<String> strs = new ArrayList<>();

        for (int i = 0; i < str.length(); ) {
            int numStart = i;
            while (special != str.charAt(i)) {
                i++;
            }
            int count = Integer.parseInt(str.substring(numStart, i++));
            strs.add(str.substring(i, i + count));
            i += count;
        }
        return strs;
    }

}
