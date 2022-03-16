package co.interleap.mocks;

public class StubUserRepository implements UserRepository {

    @Override
    public User findByEmail(String email) throws NotFoundException {
        return new User("9373940583","hello@gmail.com","sanju");
    }
}
