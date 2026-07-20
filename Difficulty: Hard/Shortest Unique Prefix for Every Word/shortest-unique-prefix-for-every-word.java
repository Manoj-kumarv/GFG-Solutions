class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int count = 0;
    }

    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (node.child[idx] == null) {
                node.child[idx] = new TrieNode();
            }

            node = node.child[idx];
            node.count++;
        }
    }

    public ArrayList<String> findPrefixes(String[] arr) {

        for (String word : arr) {
            insert(word);
        }

        ArrayList<String> ans = new ArrayList<>();

        for (String word : arr) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                node = node.child[idx];
                prefix.append(ch);

                if (node.count == 1) {
                    break;
                }
            }

            ans.add(prefix.toString());
        }

        return ans;
    }
}