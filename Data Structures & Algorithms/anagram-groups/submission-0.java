class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         Map<String, List<String>> stringListMap = new HashMap<>();
        for (String str : strs) {
            int[] signKey = new int[26];
            for (Character c : str.toCharArray()) {
                signKey[c - 'a']++;
            }
            String signKeyString = Arrays.toString(signKey);
            List<String> stringList = stringListMap.getOrDefault(signKeyString, new ArrayList<>());
            stringList.add(str);
            stringListMap.put(signKeyString, stringList);
        }

        return new ArrayList<>(stringListMap.values());
    }
}
