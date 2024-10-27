package shop.sendbox.sendbox.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AesEncryptTest {

	@Test
	@DisplayName("올바른 값을 입력시 암호화 복호화가 정상동작 합니다.")
	void encryptTest() {
		// given
		String input = "test";
		String encrypted = AesEncrypt.encrypt(input);

		// when
		String decrypted = AesEncrypt.decrypt(encrypted);

		// then
		Assertions.assertThat(decrypted).isEqualTo(input);
	}

	@Test
	@DisplayName("복호화시 값이 없으면 예외가 발생합니다.")
	void decryptTestWithNull() {
		// given
		String encrypted = null;

		// when & then
		Assertions.assertThatThrownBy(() -> AesEncrypt.decrypt(encrypted))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("암호화된 문자열에 값이 없습니다.");
	}

	@Test
	@DisplayName("복호화시 암호문 양식이 올바르지 않으면 예외가 발생합니다.")
	void decryptTestWithNot() {
		// given
		String encrypted = "test";

		// when & then
		Assertions.assertThatThrownBy(() -> AesEncrypt.decrypt(encrypted))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("암호화된 문자열 양식이 올바르지 않습니다.");
	}
}
