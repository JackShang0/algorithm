package com.algorithm.leetcode.codeThoughts.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _93backtracking {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        boolean[] booleans = new boolean[3];
        for (boolean aBoolean : booleans) {
            System.out.println(aBoolean);
        }


        ArrayList<String> strings = new ArrayList<>();
        char[][] chessboard = new char[4][4];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        }
        for(char[] c :chessboard){
            strings.add(String.copyValueOf(c));
        }
        System.out.println(strings);

    }

    public List<String> Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }


}
