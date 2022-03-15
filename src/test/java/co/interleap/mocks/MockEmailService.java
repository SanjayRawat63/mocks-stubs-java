package co.interleap.mocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockEmailService implements EmailService {
    private EmailBody lastSentEmail;

    @Override
    public void send(EmailBody emailBody){
           lastSentEmail=emailBody;
    }

     public void verify(EmailBody emailBody) {
        assertEquals(emailBody,lastSentEmail);
    }

}
