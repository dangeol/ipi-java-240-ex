package java240;

import com.ipiecoles.java.java240.BitcoinService;
import com.ipiecoles.java.java240.Produit;
import com.ipiecoles.java.java240.SpringConfig;
import com.ipiecoles.java.java240.WebPageManager;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringConfig.class)
public class BitcoinServiceIntegrationTest {

    @Autowired
    private BitcoinService bitcoinService;

    @Test
    public void integrationBitcoinRate() throws IOException {
        //Given

        //When
        Double rate = bitcoinService.getBitcoinRate();

        //Then
        Assertions.assertThat(rate).isNotNull();

    }

}
