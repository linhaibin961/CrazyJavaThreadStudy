package test;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by linhaibin on 2018/4/25.
 */
public class LhbTestMain1 {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        String s = System.currentTimeMillis() + "";
        System.out.println("BCS4361413_20007601_1524890862591".length());
        System.out.println(new Random(System.currentTimeMillis()).nextInt(1000));
//        LhbTestMain1 l = new LhbTestMain1();
//        l.eval1(2, 2, 100, 50);
    }

    private  List<Pair> eval1(int count,int rowCount, int rowStep, int colStep) {

        int startRow = 900;
        int minRow = 400;
        int maxRow = 1100;

        int startColumn = 700;
        int minColumn = 500;
        int maxColumn = 750;
        System.out.println("count = " + count);
        List<Pair> list = new ArrayList<>(count);
        while (count > 0) {
            startRow = startRow > maxRow ? (startRow % maxRow) + minRow : startRow + rowStep;
            for (int i = 0; i < rowCount && count > 0; i++) {
                if (startRow > maxRow) break;
                startColumn = startColumn > maxColumn ? (startColumn % maxColumn) + minColumn : startColumn + colStep;
                if (startColumn > maxColumn) continue;
                System.out.println("row= " + startRow + ",column= " + startColumn);
                count--;
                Pair pair = new Pair(startRow, startColumn);
                list.add(pair);
            }
        }
        System.out.println(list.size());
        System.out.println(list);
        return list;
    }


}
