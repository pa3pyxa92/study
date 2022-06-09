public class Study0806 {

    static String encode(String word) {


        word = word.toLowerCase();
        char[] wordArr = word.toCharArray();
        int index = -1;


        for (int i = 0; i < wordArr.length; i++) {

            if (wordArr[i] == ')' && index != -1) {
                index = -1;
                break;
            }

            if (wordArr[i] == ')') {
                index = i;
            }
        }


        for (int i = 0; i < wordArr.length; i++) {
            boolean isChange = false;
            boolean isSmile = false;
            char temp = wordArr[i];

            for (int j = 0; j < wordArr.length; j++) {

                if (j != i && word.charAt(j) == temp) {
                    wordArr[i] = ')';
                    wordArr[j] = ')';
                    isChange = true;
                }
            }

            if (wordArr[i] == temp && !isChange && temp != ')') {
                wordArr[i] = '(';
            }
        }

        if (index != -1) {
            wordArr[index] = '(';
        }

        String result = "";

        for (char ch : wordArr) {
            result += ch;
        }
        return result;
    }

    static int find(int[] integers){

        Integer even = null;//четный
        Integer odd = null;//нечетный

        for(int i = 0; i < integers.length; i++){


            if(integers[i] % 2 == 0){

                if(even != null && odd != null){
                    return odd;
                }

                if(even != null && odd == null){
                    for(int j = i; j<integers.length; j++){
                        if (integers[j]%2 != 0){
                            return integers[j];
                        }
                    }
                }



                even = integers[i];
            }

            if(integers[i] % 2 != 0){
                if(odd != null && even == null){
                    for(int j = i; j<integers.length; j++){
                        if (integers[j]%2 == 0){
                            return integers[j];
                        }
                    }
                }

                if(odd != null && even != null){
                    return even;
                }

                odd = integers[i];
            }
        }
        return 0;
    }

    public static double findUni(double arr[]) {

        Double first = null;

        for (int i = 0; i < arr.length; i++) {

            if (first == null){
                first = arr[i];
                continue;
            }

            if(first == arr[i]){
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] != first) {return arr[j];}
                }
            }

            if(first != arr[i]){
                return  arr[i] == arr[i+1] ? first:arr[i];
            }
        }
        return 0.42;
    }

    public static int countBits(int n){

        String bin = Integer.toBinaryString(n);
        int counter = 0;

        for(int i = 0; i<bin.length(); i++){
            if(bin.charAt(i) == '1'){counter++;}
        }

        return counter;
    }

}
