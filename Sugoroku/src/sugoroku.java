import java.util.Random;

/**
 * @version 1.0 2013/05/14
 * @author Naoki Kamimura
 * @param args
 */
public class sugoroku {

	public static void main(String[] args) {
		// 初期設定
		final int SNAKE_POSITON = 4; // 2マス戻るイベント
		final int BRIDGE_POSITION = 6;// 2マス進むイベント
		final int GOAL_POSITION = 11;// ゴールの位置
		int positionNow = 0;// 現在の位置
		int randomDiceNumber = 0;// サイコロの出る目
		boolean winOrLoseJudgment;// 勝ち負けの判定
		int throwDiceCount;// 投げたサイコロの回数

		// ゴールに到達するか超えるまでサイコロを振る
		for (int i = 0; i < 11; i++) {
			// サイコロを投げた回数を取得し表示
			throwDiceCount = getDiceCount(i);
			System.out.println("------" + throwDiceCount + "投目------");
			System.out.println("サイコロを投げます･･･");

			// 1-6のランダムな値をサイコロへ入れて表示
			randomDiceNumber = getRandomDiceNumber();
			System.out.println("出た数字は" + randomDiceNumber + "です");

			// 現在位置にサイコロの出た目を足して入れる
			positionNow += getPositionNow(randomDiceNumber);
			System.out.println(randomDiceNumber + "マス進みます");
			System.out.println("現在位置は" + positionNow + "マスです");

			// ヘビのマス目に止まったら二つ戻る
			if (positionNow == SNAKE_POSITON) {
				positionNow -= 2;
				System.out.println("ヘビのマス目です。2つ戻ります");
				System.out.println("現在位置は" + positionNow + "マスです");
			}
			// 橋のマス目に止まったら二つ進む
			if (positionNow == BRIDGE_POSITION) {
				positionNow += 2;
				System.out.println("橋のマス目です。2つ進みます");
				System.out.println("現在位置は" + positionNow + "マスです");
			}
			// ゴールに到達したら
			if (positionNow == GOAL_POSITION) {
				winOrLoseJudgment = true;
				System.out.println(getEndMessage(winOrLoseJudgment));
				return;
			}
			// ゴールのマス目を超えたら
			else if (10 < positionNow) {
				winOrLoseJudgment = false;
				System.out.println(getEndMessage(winOrLoseJudgment));
				return;
			}
		}
	}

	/**
	 * ランダムな1-6の数値を取り出す
	 *
	 * @return randomDiceNumber
	 */
	private static int getRandomDiceNumber() {
		Random random = new Random();
		int randomDiceNumber = random.nextInt(6) + 1;
		return randomDiceNumber;
	}

	/**
	 * 勝ち負けの判定
	 *
	 * @param judgment
	 * @return 終了及び結果メッセージ
	 */
	private static String getEndMessage(boolean judgment) {
		String goalMessage = "終了です！";
		String winMessage = "ゴールに止まる事が出来ました！";
		String loseMessage = "ゴールに止まる事が出来ませんでした・・・";
		// 勝った場合
		if (judgment == true) {
			return goalMessage + "\n" + winMessage;
		}
		return goalMessage + "\n" + loseMessage;
	}

	/**
	 * サイコロを投げた回数
	 *
	 * @param getCount
	 *            　
	 * @return count += 1　回数を1増やす
	 */
	private static int getDiceCount(int getCount) {
		int count = getCount;
		return count += 1;
	}

	/**
	 * 現在の位置を返す
	 *
	 * @param position
	 * @return positionNow　現在の位置
	 */
	private static int getPositionNow(int position) {
		int positionNow = 0;
		positionNow += position;
		return positionNow;
	}

}
