@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    public UserAccount createUser(UserAccount user) {
        if (repo.existsByEmail(user.getEmail()))
            throw new BadRequestException("Email exists");
        user.setActive(true);
        return repo.save(user);
    }

    public UserAccount updateUser(Long id, UserAccount u) {
        UserAccount db = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        db.setEmail(u.getEmail());
        db.setFullName(u.getFullName());
        return repo.save(db);
    }

    public UserAccount getUserById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public List<UserAccount> getAllUsers() {
        return repo.findAll();
    }

    public void deactivateUser(Long id) {
        UserAccount u = getUserById(id);
        u.setActive(false);
        repo.save(u);
    }
}
