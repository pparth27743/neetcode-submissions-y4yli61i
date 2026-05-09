class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> strsMap = new HashMap<>();

        for(String str: strs) {
            TreeMap<Character, Integer> mp = new TreeMap<>();
        
            // compute frequency of characters within str
            for(char ch : str.toCharArray()) {
                mp.put(ch, mp.getOrDefault(ch, 0) + 1);        
            }

            // compute custom hash of str
            StringBuilder sb = new StringBuilder();
            for(Map.Entry<Character, Integer> entry : mp.entrySet()) {
                sb.append(entry.getKey());
                sb.append(entry.getValue());
            }
            String strHash = sb.toString();


            ArrayList<String> arr = strsMap.getOrDefault(strHash, new ArrayList<String>());
            arr.add(str);
            strsMap.put(strHash, arr);
        }

        List<List<String>> lst = new ArrayList<>();
        
        for(Map.Entry<String, ArrayList<String>> entry : strsMap.entrySet()) {
            lst.add(entry.getValue());
        }

        return lst;

    }
}
