class Solution {
    public int[] plusOne(int[] digits) {
        int i =digits.length-1;
        for(;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
                continue;
            }else{
                digits[i]=digits[i]+1;
                break;
            }
        }
        if(i==-1){
            int[] newdigits = new int[digits.length+1];
            newdigits[0]=1;
            for(int j=1;j<newdigits.length;j++){
                newdigits[j]=0;
            }
            return newdigits;
        }else{
            return digits;
        }
    
    }
    
}
