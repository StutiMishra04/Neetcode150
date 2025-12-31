/*

Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Implement the encode and decode methods.

Input: dummy_input = ["Hello","World"]

Output: ["Hello","World"]

Explanation:
Machine 1:
Codec encoder = new Codec();
String msg = encoder.encode(strs);
Machine 1 ---msg---> Machine 2

Machine 2:
Codec decoder = new Codec();
String[] strs = decoder.decode(msg);

*/

class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();

        for(String str:strs){
            result.append(str.length()).append('#').append(str);
            // for strs = ["neet","code","love","you"]
            // the result is "4#neet4#code4#love3#you"
            // the format is <len>#<word><len>#<word><len>#<word>...
        }
        return result.toString();
    }

    public List<String> decode(String str) {
       List<String> res = new ArrayList<>();
       int i = 0;
       while(i < str.length()){
        int j = i; // j will be our pointer for word
        while(str.charAt(j) != '#'){
            j++;
        }
        int length = Integer.parseInt(str.substring(i,j));
        // this converts "4" of "4#neet" to 4. j is pointing to #
        i = j + 1; // now i is at n of neet
        j = i + length; // now j is beyond neet and at another number of word
        res.add(str.substring(i,j));
        i = j; // i and j move onto next encoded word of string
       }
       return res;
    }
}