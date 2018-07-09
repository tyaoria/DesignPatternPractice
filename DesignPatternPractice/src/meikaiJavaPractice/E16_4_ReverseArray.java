package meikaiJavaPractice;

import java.util.Scanner;

/**
 * 演習16_4 <br />
 * 前問と同様に、List16-8(次ページ)のメソッドreverseに対して、
 * 仮引数aに受け取った参照が空参照であった場合に、
 * 何らかの対処を行うように変更したプログラムを作成せよ
 * @author chaoria
 *
 */
public class E16_4_ReverseArray {

	/**
	 *  画面からの入力を受け付けるスキャナー
	 */
	static Scanner stdIn = new Scanner(System.in);
	/**
	 * 半分にするために割る数
	 */
	static final int HALF_DEVIDE_VALUE = 2;

	/**
	 * 指定した配列より、指定した位置の値を入れ替える
	 * @param targetArray:交換が行われる配列
	 * @param target:交換対象
	 * @param destination:対象先
	 */
	static void swap(int[] targetArray, int target, int destination) {
		// 交換を行うため、交換対象を退避する
		int tempNumber = targetArray[target];
		// 交換元に交換先となる値を入れる
		targetArray[target] = targetArray[destination];
		// 交換先に退避した値を入れる
		targetArray[destination] = tempNumber;
	}

	/**
	 * 対象の配列の要素の並びを反転する（テストのため誤りがある）
	 * @param targetArray
	 */
	static void reverse(int targetArray[]) {
		// 例外を補足する
		try {
			// 要素の並びを反転させるため、配列中央までループする
			for (int i = 0; i < targetArray.length / HALF_DEVIDE_VALUE; i++) {
				// 対象の配列の値を入れ替える(わざと例外を発生させるため length - i のみ。length - i - 1が正解)
				swap(targetArray, i, targetArray.length - i);
			}
			// 対象の配列の参照が空の場合に発生するエラーを補足する
		} catch (NullPointerException nullPointerException) {
			// 配列の内容が不正であることを示すメッセージでRuntimeExceptionをthrowする
			throw new RuntimeException("配列の内容が不正でした");

			// 対象の配列の添え字が不正の場合に発生するエラーを補足する
		} catch (ArrayIndexOutOfBoundsException arrayIndexoutOfBoudsException) {
			// 添え字の値が不正であることを示すメッセージでRuntimeExceptionをthrowする
			throw new RuntimeException("添え字の値が不正です");
		}
	}

	// メインメソッド
	public static void main(String[] args) {
		// 配列を作成する(エラーを発生させるためnullで作成する)
		int[] targetArray = null;
		// reverse関数で発生する例外を補足する
		try {
			// エラーを発生させるため、値を入れずに配列の前後を入れ替える(NullPointerExceptionを想定)
			reverse(targetArray);
			// 再throwしているのでRuntimeExceptionを補足する
		} catch (RuntimeException runtimeException) {
			// 例外の種類を出力する
			System.out.println("例外：" + runtimeException);
			// 例外の原因(Message)を出力する
			System.out.println("原因：" + runtimeException.getMessage());
		}
		// 配列の実態を作成する
		targetArray = createArray();
		// 配列の各要素に値を設定させる
		inputArrayValue(targetArray);
		// 反転前の配列の要素を表示する
		printArrayValue(targetArray, "---反転前の配列---");
		try {
			// 配列の要素を反転させる
			reverse(targetArray);
			// 発生が想定されるRuntimeExceptionを補足する
		} catch (RuntimeException runtimeException) {
			// 例外の種類を出力する
			System.out.println("例外：" + runtimeException);
			// 例外の原因(Message)を出力する
			System.out.println("原因：" + runtimeException.getMessage());
		}
		// 反転後の配列の要素を表示する
		printArrayValue(targetArray, "---反転後の配列---");
		// 作成したスキャナーを閉じる
		stdIn.close();
	}

	/**
	 * 入力値に基づき配列を作成して返却する
	 * @return 入力値の長さの数値配列
	 */
	static int[] createArray() {
		// 配列の要素数の入力を促す
		System.out.println("配列の要素数を入力してください。>");
		// 入力値を整数として受け取る。(テストのため、当入力の例外処理は行わない)
		int lengthValue = stdIn.nextInt();
		// 作業用の配列を作成して返却する
		return new int[lengthValue];
	}

	/**
	 * 入力された値を基に、配列の各要素に値を設定する
	 * @param targetArray:値を設定する対象の配列
	 */
	static void inputArrayValue(int[] targetArray) {
		// 配列の各値に対し値を設定するため配列数ループする
		for (int i = 0; i < targetArray.length; i++) {
			// 配列の添え字番号を合わせ、どこに値を設定するか表示する
			System.out.println("array[" + i + "]:");
			// 入力された値を設定する。(テストの絶え、当入力の例外処理は行わない)
			targetArray[i] = stdIn.nextInt();
		}
	}

	/**
	 * 配列の各要素を表示する
	 * @param targetArray
	 */
	static void printArrayValue(int[] targetArray, String message) {
		// 反転後の配列の中身を表示させる
		System.out.println(message);
		// 配列の中身すべてを表示させるため、配列数ループする
		for (int i = 0; i < targetArray.length; i++) {
			// 配列個別の値を表示する
			System.out.println("Array[" + i + "] = " + targetArray[i]);
		}
	}
}
