package mx.com.garnet.common;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("mx.com.garnet")
public class GarnetCommonApplicationTests {
	/*
	private static Logger log = LogManager.getLogger(EzWalletCommonApplicationTests.class);



	@Test
	public void contextLoads() {
	}

	@Test
	public void whenSendSms_thenGetsCode100(){
		smsApiService = new SmsApiService();
		boolean successExpected = true;
		String codeExpected = "100";
		GeneralResponse response = new GeneralResponse();
		EnviarSmsApiRequest request = new EnviarSmsApiRequest();
		request.setMensaje("Código de EZWallet App: 71900");
		request.setNumeroDestinatario("7227099104");
		response = smsApiService.enviarSms(request);

		assertThat(response.getCode()).isEqualTo(codeExpected);
	}

	@Test
	public void whenNumberIsIncorrect_thenGetsCode207AndSuccessFalse(){
        smsApiService = new SmsApiService();
        String codeExpected = "307";
        GeneralResponse response = new GeneralResponse();
        EnviarSmsApiRequest request = new EnviarSmsApiRequest();
        request.setMensaje("Código de EZWallet App: 71900");
        request.setNumeroDestinatario("0000000000");
        response = smsApiService.enviarSms(request);

        assertThat(response.getCode()).isEqualTo(codeExpected);
    }

    @Test
    public void whenMessageIsNotPresent_thenGetsCode103AndSuccessFalse(){
        smsApiService = new SmsApiService();
        String codeExpected = "103";
        GeneralResponse response = new GeneralResponse();
        EnviarSmsApiRequest request = new EnviarSmsApiRequest();
        request.setMensaje(null);
        request.setNumeroDestinatario("7227099104");
        response = smsApiService.enviarSms(request);

        assertThat(response.getCode()).isEqualTo(codeExpected);
    }

    @Test
    public void whenPhoneNumberIsWrong_thenGetsCode307AndSuccessFalse(){
        smsApiService = new SmsApiService();
        String codeExpected = "307";
        GeneralResponse response = new GeneralResponse();
        EnviarSmsApiRequest request = new EnviarSmsApiRequest();
        request.setMensaje("Código de EZWallet App: 71900");
        request.setNumeroDestinatario("");
        response = smsApiService.enviarSms(request);

        assertThat(response.getCode()).isEqualTo(codeExpected);
    }

*/

}
