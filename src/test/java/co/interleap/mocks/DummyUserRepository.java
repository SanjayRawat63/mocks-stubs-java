package co.interleap.mocks;

public class DummyUserRepository implements UserRepository {

    @Override
    public User findByEmail(String email) throws NotFoundException {
        return null;
    }
}
