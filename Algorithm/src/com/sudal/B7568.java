package com.sudal;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Person {
    int x = 0;
    int y = 0;
    int rank = 1;

    Person(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }


}

public class B7568 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        Person[] person = new Person[num];

        for (int i =0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
           person[i]= new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (Person target : person) {
            for (Person person1 : person) {
                if (target.getX() < person1.getX() && target.getY() < person1.getY())
                    target.setRank(target.getRank()+1);
            }
            sb.append(target.getRank() + " ");
        }
        System.out.println(sb);
        br.close();
    }
}
