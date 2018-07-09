package meikaiJavaPractice;

/**
 * 範囲外であることを示す例外
 * @author chaoria
 * @date 2018/07/09
 */
public class E16_2_RangeError extends RuntimeException {
	/**
	 * コンストラクタ。受け取った値を範囲外の値としてエラーを作成する。
	 * @param number
	 */
	public E16_2_RangeError(int number) {
		// 引数の値を範囲外の値としてエラーメッセージを作成し、エラーオブジェクトを作成する。
		super("範囲外の値:" + number);
	}
}

