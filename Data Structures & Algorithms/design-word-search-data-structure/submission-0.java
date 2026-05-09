class WordDictionary {

   static class TrieNode {
        boolean isWord;
        TrieNode children[];

        TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
   }

   TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch-'a'] == null)
                curr.children[ch-'a'] = new TrieNode();
            curr = curr.children[ch-'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();

        return search2(charArray, 0, root);
    }


    private boolean search2(char[] charArray, int idx, TrieNode root) {
    
        if(root == null)
            return false;

        TrieNode curr = root;
        for(int i=idx; i<charArray.length; i++) {
            char ch = charArray[i];
            if(charArray[i] != '.') {
                if(curr.children[ch-'a'] == null)
                    return false;
                curr = curr.children[ch-'a'];
            }
            else {
                boolean isMatch = false;
                for(int k=0; k<26; k++) {
                    isMatch = isMatch || search2(charArray, i+1, curr.children[k]);
                }
                return isMatch;
            }
        }
        return curr.isWord;
    }



}
