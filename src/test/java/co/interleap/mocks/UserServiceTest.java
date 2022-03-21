package co.interleap.mocks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void shouldSendWelcomeEmail() {
        EmailService emailService = mock(EmailService.class);
        UserService userService = new UserService(null, emailService);
        userService.sendWelcomeEmail("hello@gmail.com");
        EmailBody expectedEmail = new EmailBody("Welcome", "Welcome to the portal", "hello@gmail.com");
        verify(emailService).send(expectedEmail);
    }

    @Test
    void shouldSendRegisteredPhoneNumberIfUserAccountExists() throws NotFoundException {
        EmailService emailService = mock(EmailService.class);
        UserRepository userRepository = mock(UserRepository.class);
        Mockito.when(userRepository.findByEmail("hello@gmail.com")).thenReturn(new User("9373940583", "hello@gmail.com", "sanju"));
        UserService userService = new UserService(userRepository, emailService);
        userService.sendRegisteredPhoneNumber("hello@gmail.com");
        EmailBody expectedEmail = new EmailBody("Account Details",
                "Here is your Registered Phone Number: \n" + "9373940583",
                "hello@gmail.com");
        verify(emailService).send(expectedEmail);


    }

    @Test
    void sendAccountNotFoundEmailForUnregisteredUsersWhenTryingToGetRegisteredPhoneNumber() throws NotFoundException {
        MockEmailService emailService = new MockEmailService();
        StubUserRepository userRepository = new StubUserRepository();
        UserService userService = new UserService(userRepository, emailService);
        userService.sendRegisteredPhoneNumber("world@gmail.com");
        EmailBody expectedEmail = new EmailBody("Account Not Found",
                "We do not have a registered account matching your email address",
                "world@gmail.com");
        emailService.verify(expectedEmail);
    }
}