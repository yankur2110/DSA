class Solution {
    char carry='0';

    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();

        //to ensure a is always greater.
        if(b.length()>a.length()){
            String temp = a;
            a=b;
            b=temp;
        }
        stringBuilder = new StringBuilder(a);
        a = stringBuilder.reverse().toString();
        stringBuilder = new StringBuilder(b);
        b = stringBuilder.reverse().toString();
        stringBuilder = new StringBuilder();

        for(int i=0;i<a.length();i++){
            if(i<b.length()){
                stringBuilder.append(getDigit(a.charAt(i),b.charAt(i)));
            }else{
                stringBuilder.append(getDigit(a.charAt(i),'0'));
            }
        }
        if(carry=='1'){
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }

    public StringBuilder getDigit(char a, char b){
        StringBuilder returnString= new StringBuilder();

        if(carry=='1'){
            if(a=='1' && b=='1'){
                returnString.append("1");
                carry='1';
            }else if(a=='1' && b=='0' || a=='0' && b=='1'){
                returnString.append("0");
                carry='1';
            }else{
                returnString.append("1");
                carry='0';
            }

        }else{
            if(a=='1' && b=='1'){
                returnString.append("0");
                carry='1';
            }else if(a=='1' && b=='0' || a=='0' && b=='1'){
                returnString.append("1");
            }else{
                returnString.append("0");
            }
        }

        return returnString;

    }
}
