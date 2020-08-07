package test;

/**
 * Created by linhaibin on 2018/4/25.
 */
public class GenerateTNMapUserCashRecord {

    public static void main(String[] args) {
        double totalAsset = 80000;
        double targetTotalAdd = 180.82;
        double mapUserQuitTotal = totalAsset + targetTotalAdd;
        double userMapWaitProfit = 0.88 * mapUserQuitTotal;
        double quitWaitProfit = mapUserQuitTotal - userMapWaitProfit;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                System.out.println(i+" mapUserQuitTotal="+MathUtils.roundHalfUp(mapUserQuitTotal*0.1));
            }else {
                System.out.println(i+" mapUserQuitTotal="+MathUtils.roundHalfUp(mapUserQuitTotal*0.045455));
            }
            System.out.println(i+" protect ="+MathUtils.roundHalfUp(mapUserQuitTotal*0.1));

        }
    }
}
