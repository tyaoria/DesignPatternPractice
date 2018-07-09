package meikaiJavaPractice;

import java.util.Scanner;

/**
 * 演習16_2 <br />
 * List16-6(p.523)のtry文では、ParameterRangeErrorの例外とResultRangeException例外を、別々の例外ハンドラで補足している。
 * 単一の例外ハンドラで補足するように変更したプログラムを作成せよ
 * @author chaoria
 */
public class E16_2_RangeErrorTester {

	/**
	 * 一桁の値の最小値(マイナスは二桁と扱う)
	 */
	static final int ONE_DIGIT_MIN = 0;
	/**
	 * 一桁の値の最大値
	 */
	static final int ONE_DIGIT_MAX = 9;

	/**
	 * 値が範囲外であることを示すエラーメッセージ
	 */
	static final String RANGE_EXCEPTION_ERROR_MESSAGE = "値が範囲外です。";

	/**
	 * 入力値が一桁であるかチェックする
	 * @param inputNumber
	 */
	static boolean isNumberValid(int inputNumber) {
		// 入力値が一桁であるかどうかの結果をboolで返却する
		return ONE_DIGIT_MIN <= inputNumber && inputNumber <= ONE_DIGIT_MAX;
	}

	/**
	 * 一桁同士の足し算を行う。入力値、計算結果いずれかが1桁を超えた場合はエラーをthrowする
	 * @param firstNumber
	 * @param secondNumber
	 * @return 引数を足した結果
	 * @throws E16_2_ParameterRangeError
	 * @throws E16_2_ResultRangeError
	 */
	static int addNumber(int firstNumber, int secondNumber) throws E16_2_ParameterRangeError, E16_2_ResultRangeError {
		// 一つ目の値が1桁でない場合
		if (!isNumberValid(firstNumber)) {
			// 引数が範囲外であることを示すエラーを作成してthrowする。
			throw new E16_2_ParameterRangeError(firstNumber);
		}
		// 二つ目の値が1桁でない場合
		if (!isNumberValid(secondNumber)) {
			// 引数が範囲外であることを示すエラーを作成してthrowする。
			throw new E16_2_ParameterRangeError(secondNumber);
		}
		// 引数が正常であれば、二つの数を加算する。
		int addResult = firstNumber + secondNumber;
		// 加算した結果が一桁ではない場合
		if (!isNumberValid(addResult)) {
			// 計算結果が範囲外であることを示すエラーを作成してthrowする。
			throw new E16_2_ResultRangeError(addResult);
		}
		// 計算結果が正常であれば、値を返却する。
		return addResult;

	}

	// メインメソッド
	public static void main(String[] args) {

		// 画面からの入力を受け付けるスキャナーを作成する
		Scanner stdIn = new Scanner(System.in);

		// 足す値の一つ目の入力を促す
		System.out.println("一つ目の値を入力してください。>");
		// 入力値を整数として受け取る。(テストのため、当入力の例外処理は行わない)
		int firstNumber = stdIn.nextInt();
		// 足す値の二つ目の入力を促す
		System.out.println("二つ目の値を入力してください。>");
		// 入力値を整数として受け取る。(テストのため、当入力の例外処理は行わない)
		int secondNumber = stdIn.nextInt();

		// 例外を補足する
		try {
			// 入力された値の加算結果を出力する
			System.out.println("それらの和は" + addNumber(firstNumber, secondNumber) + "です。");
			// RangeExceptionが発生した場合
		} catch (E16_2_RangeError rangeError) {
			// RangeExceptionが発生したことを通知する。
			System.out.println(RANGE_EXCEPTION_ERROR_MESSAGE);
			// catchしたエラーメッセージを出力する
			System.out.println(rangeError.getMessage());
			// 例外の補足終了後
		} finally {
			// 作成したスキャナーを閉じる
			stdIn.close();
		}
	}

}
