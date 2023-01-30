public class Replace {

    static String replaceWith(String in, String[] searchFor, String replaceWith){
        for (String e : searchFor){
            in = replaceWith(in,e,replaceWith);
        }
        return in;
    }
    
    static String replaceWith(String in, String searchFor, String replaceWith) {
        //checks if the String that has been specified in the parameters contains the § char
        if(contains(in,'§'))
            return "Error";
        char[] temp = toArray(in);

        //searching the array for the strings that should be replaced and replaces them with § chars
        int TimesToReplace = 0;
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] == searchFor.charAt(0)){
                int tempInt = i;
                boolean next = false;
                for (int j = 0; j < searchFor.length(); j++) {
                    if(temp[tempInt] != searchFor.charAt(j)){
                        next = true;
                    }
                    tempInt++;
                }
                if (next)
                    continue;
                tempInt = i;
                TimesToReplace++;
                for (int j = 0; j < searchFor.length(); j++) {
                    temp[tempInt] = '§';
                    tempInt++;
                }
            }
        }

        //calculating the new size of the array
        char[] chars = new char[SizeWithout(temp,'§') + replaceWith.length() * TimesToReplace];

        //replacing
        int c = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '§') {
                for (int j = 0; j < replaceWith.length(); j++) {
                    chars[c] = replaceWith.charAt(j);
                    c++;
                }
                i += searchFor.length() - 1;
            } else {
                chars[c] = temp[i];
                c++;
            }
        }

        //returning the result
        return toStr(chars);
    }

    //checks of a String contains a char specified in the parameters
    static boolean contains(String str, char c){
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c){
                return true;
            }
        }
        return false;
    }

    //converts a char array to a String
    static String toStr(char[] c){
        String str = "";
        for (char C : c)
            str += C;
        return str;
    }

    //returns the size of a char array without counting a char specified in the parameters
    static int SizeWithout(char[] cs, char c){
        int s = 0;
        for (char C : cs)
            if(C != c)
                s++;
        return s;
    }

    //returns a char array containing the string specified in the parameters
    static char[] toArray(String s){
        char[] chars = new char[s.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = s.charAt(i);
        }
        return chars;
    }
}


