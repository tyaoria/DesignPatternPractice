package meikaiJavaPractice;
/**
 * 仮引数が範囲外であることを示す例外
 * @author chaoria
 * @date 2018/07/09
 */
public class E16_2_ParameterRangeError extends E16_2_RangeError {
	/**
	 * コンストラクタ。受け取った値を範囲外の値としてエラーを作成する。
	 * @param number
	 */
	public E16_2_ParameterRangeError(int number) {
		// エラー作成は親クラスの処理をそのまま使用する。
		super(number);
	}

}
