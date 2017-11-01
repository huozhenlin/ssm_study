/**
 * Created by hzl on 2017/6/8.
 */
public class ConcatTest {
    int M;
    int concat(char s[],char t[]){
        int i=s.length;
        int j=t.length;
        int k;

        if((i+j)>M){
            return 0;
        }
        for (k=0;k<j;k++){
            s[i+k]=t[k];
            return 1;
        }
        return 0;
    }
}
