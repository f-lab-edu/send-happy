package shop.sendbox.sendbox.buyer;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BuyerServiceTest {

	@Autowired
	BuyerService buyerService;

	@Test
	@DisplayName("구매자는 정보를 입력하여 가입할 수 있다.")
	void signUp() {
		// given
		final LocalDateTime createdAt = LocalDateTime.of(2024, 10, 22, 11, 28);
		final String email = "test@gmail.com";
		final String password = "password";
		final String name = "홍길동";
		final String phoneNumber = "01012345678";
		final String createdBy = "admin";
		BuyerRequest buyerRequest = new BuyerRequest(email, password, name, phoneNumber, null, createdBy);

		// when
		BuyerResponse buyerResponse = buyerService.signUp(buyerRequest, createdAt);

		// then
		Assertions.assertThat(buyerResponse.getEmail()).isEqualTo(email);
		Assertions.assertThat(buyerResponse.getName()).isEqualTo(name);
		Assertions.assertThat(buyerResponse.getPhoneNumber()).isEqualTo(phoneNumber);
		Assertions.assertThat(buyerResponse.getBuyerStatus()).isEqualTo("ACTIVE");
	}
}