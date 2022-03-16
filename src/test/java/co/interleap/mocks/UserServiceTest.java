package co.interleap.mocks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void shouldSendWelcomeEmail() {
        MockEmailService emailService=new MockEmailService();
        UserService userService = new UserService(null,emailService);
        userService.sendWelcomeEmail("hello@gmail.com");
        EmailBody expectedEmail = new EmailBody("Welcome","Welcome to the portal","hello@gmail.com");
        emailService.verify(expectedEmail);
    }

    @Test
    void shouldSendRegisteredPhoneNumberIfUserAccountExists() {
        MockEmailService emailService=new MockEmailService();
        StubUserRepository userRepository=new StubUserRepository();
        UserService userService = new UserService(userRepository,emailService);
        userService.sendRegisteredPhoneNumber("hello@gmail.com");
        EmailBody expectedEmail = new EmailBody("Account Details",
                "Here is your Registered Phone Number: \n" + "9373940583",
                "hello@gmail.com");
        emailService.verify(expectedEmail);

    }

    @Test
    void sendAccountNotFoundEmailForUnregisteredUsersWhenTryingToGetRegisteredPhoneNumber() {

    }
}