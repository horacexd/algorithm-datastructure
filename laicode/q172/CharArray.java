package laicode.q172;

class CharArray {
    public String replace(String input, String source, String target) {
        if (input == null || input.length() < source.length()) {
            return "";
        }
        // source.length() >= target.length(); inplace from left to right
        char[] array = input.toCharArray();
        int slow = 0;
        if (source.length() >= target.length()) {
            for (int i = 0; i < array.length; i++) {
                if (match(array, i, source)) {
                    replace(array, slow, target);
                    i += source.length() - 1;
                    slow += target.length();
                } else {
                    array[slow++] = array[i];
                }
            }
            return new String(array, 0, slow);
        } else {
        // source.length() < target.length(); from right to left
            int diff = target.length() - source.length();
            int num = 0;
            for (int i = 0; i < array.length; i++) {
                if (match(array, i, source)) {
                    num++;
                    i += source.length() - 1; 
                }
            }
            char[] result = new char[array.length + num * diff];
            int j = 0;
            for (int i = 0; i < array.length; i++) {
                if (match(array, i, source)) {
                    replace(result, j, target);
                    i += source.length() - 1;
                    j += target.length();
                } else {
                    result[j++] = array[i];
                }
            }
            return new String(result);
        }
    }

    private boolean match(char[] array, int start, String source) {
        if (start < 0) {
            return false;
        }
        if (start + source.length() > array.length) {
            return false;
        }
        for (int i = 0; i < source.length(); i++) {
            if (array[start + i] != source.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void replace(char[] array, int start, String target) {
        for (int i = 0; i < target.length(); i++) {
            array[start++] = target.charAt(i);
        }
    }

    public static void main(String[] args) {
        CharArray sol = new CharArray();
        System.out.println(sol.replace("appledogapple", "apple", "cat"));
        System.out.println(sol.replace("bananaandbanana", "ana", "bobo"));
        System.out.println(sol.replace("aaaaa", "aa", "bbb"));


    }
}