package com.company.lp;

public class Ex01 {

    public static int solution(String s) {
        int answer = 0;

        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length-1;i++) {
            if(ch[i] == 'a') {
                for(int j=i+1;j<ch.length;j++) {
                    if(ch[j] == 'z') {
                        answer++;
                        break ;
                    } else if(ch[j] == 'a') break ;
                }
            } else if(ch[i] == 'z') {
                for(int j=i+1;j<ch.length;j++) {
                    if(ch[j] == 'a') {
                        answer++;
                        break ;
                    } else if(ch[j] == 'z') break ;
                }
            }
        }
        return answer;
    }

    public static void main(String ... v) {
        System.out.println(solution("abcd"));
    }
}
