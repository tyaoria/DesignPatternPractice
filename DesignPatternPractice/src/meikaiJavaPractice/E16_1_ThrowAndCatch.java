package meikaiJavaPractice;

import java.util.Scanner;

/**
 * 演習16_1 <br />
 * List16-4(p.518)のtry文では、Exceptionの例外とRuntimeException例外を、単一の例外ハンドラで補足している。
 * 二つの例外を別々に補足するように変更したプログラムを作成せよ。
 * @author chaoria
 */
public class E16_1_ThrowAndCatch {

	/**
	 * Exception用のエラーコード
	 */
	static final int ERROR_TYPE_EXCEPTION = 1;
	/**
	 * RuntimeException用のエラーコード
	 */
	static final int ERROR_TYPE_RUNTIME_EXCEPTION = 2;

	/**
	 * RuntimeException発生時のエラーメッセージ
	 */
	static final String RUNTIME_ERROR_MESSAGE = "Catch Runtime Exception.";
	/**
	 * Exception発生時のエラーメッセージ
	 */
	static final String ERROR_MESSAGE = "Catch Exception.";
	/**
	 * 入力値がエラーと扱われない場合のメッセージ
	 */
	static final String NOT_COVERED_ERROR_MESSAGE = "エラー対象外の入力値です。";

	/**
	 * 引数の値に応じて、指定した例外をthrowする。
	 * @author chaoria
	 * @param errorType
	 * @throws Exception
	 * @作成日 2018/07/09
	 */
	static void check(int errorType) throws Exception {
		// errorTypeの値により、throwするExceptionを切り替える
		switch (errorType) {
		// タイプがExceptionの場合
		case ERROR_TYPE_EXCEPTION:
			// java.lang.Exceptionをthrowする。(エラー全般)
			throw new Exception();
			// タイプがRuntimeExceptionの場合
		case ERROR_TYPE_RUNTIME_EXCEPTION:
			// java.lang.RuntimeExceptionをthrowする。(実行中エラー)
			throw new RuntimeException();
			// 上記以外の場合
		default:
			// エラー該当無しのメッセージを出力する。
			System.out.println(NOT_COVERED_ERROR_MESSAGE);
			break;
		}
	}

	/**
	 * 引数の値を基にしたエラーチェック処理を呼び出す。
	 * @author chaoria
	 * @param errorType
	 * @throws Exception
	 * @作成日 2018/07/09
	 */
	static void callCheckMethod(int errorType) throws Exception {
		// エラーチェック処理を呼び出す
		check(errorType);
	}

	// メインメソッド
	public static void main(String[] args) {
		// 画面からの入力を受け付けるスキャナーを作成する
		Scanner stdIn = new Scanner(System.in);

		// チェックする値の入力を促す
		System.out.println("errorTypeの値を入力してください。>");
		// 入力値を整数として受け取る。(テストのため、当入力の例外処理は行わない)
		int errorType = stdIn.nextInt();

		// 例外を補足する
		try {
			// 入力値のチェック処理を行う
			callCheckMethod(errorType);
			// RuntimeExceptionが発生した場合
		} catch (RuntimeException runtimeError) {
			// RuntimeExceptionが発生したことを通知する。
			System.out.println(RUNTIME_ERROR_MESSAGE);
			// catchしたエラーメッセージを出力する
			System.out.println(runtimeError.getMessage());
			// 何かしらの例外が発生した場合
		} catch (Exception error) {
			// Exceptionが発生したことを通知する。
			System.out.println(ERROR_MESSAGE);
			// catchしたエラーメッセージを出力する
			System.out.println(error.getMessage());
			// 例外の補足終了後
		} finally {
			// 作成したスキャナーを閉じる
			stdIn.close();
		}
	}

}
