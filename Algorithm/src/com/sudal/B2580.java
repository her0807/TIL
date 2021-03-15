package com.sudal;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class B2580 {

    static ArrayList<int[]> empty_spots = new ArrayList();
    static int[][] matrix = new int[9][9];

    public static void main(String[] args) throws IOException{
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<9; i++){ // 입력에 따라 현재 스도쿠 판 만들기
            for(int j=0; j<9; j++){
                matrix[i][j] = sc.nextInt();
                if(matrix[i][j] == 0) empty_spots.add(new int[]{i,j});
            }
        }

        sudoku(0); // 스도쿠 실행

        // BufferedWriter를 이용하여 출력
        for(int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                buf.write(matrix[i][j] + " ");
            }
            buf.newLine();
        }
        buf.flush();
    }

    static boolean sudoku(int count){
        if(count == empty_spots.size()){ // 종료조건
            return true;
        }

        int[] position = empty_spots.get(count); // 다음 빈칸의 위치 가져옴
        int n = position[0];
        int m = position[1];
        for(int i = 1; i<10; i++){ // 1~9까지 반복문,
            if(isPromising(n, m, i)){ // 유망성 판단
                matrix[n][m] = i;
                if (sudoku(count+1)) return true; // 끝에 도달했으면 return true
                else matrix[n][m] = 0; // 끝에 도달하지 못했으면 해당 칸 초기화
            }
        }

        return false;
    }


    static boolean isPromising(int n, int m, int num){
        int len = matrix.length;
        int n_block = n / 3; // 현재 블록의 세로 위치
        int m_block = m / 3; // 현재 블록의 가로 위치

        for(int i =0; i<len; i++){ // 조건1: 가로세로 판단
            if(matrix[n][i] == num) return false;
            if(matrix[i][m] == num) return false;
        }

        for(int i=0; i<3; i++){ // 조건2: 같은 블록 내 판단
            for(int j=0; j<3; j++){
                if(matrix[(n_block*3)+i][(m_block*3)+j] == num)
                    return false;
            }
        }

        return true;
    }
}


