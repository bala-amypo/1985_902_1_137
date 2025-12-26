@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    public UserAccount create(UserAccount user) {
        if (repo.existsByEmail(user.getEmail()))
            throw new BadRequestException("Email exists");
        return repo.save(user);
    }

    public UserAccount get(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public List<UserAccount> getAll() {
        return repo.findAll();
    }

    public void deactivate(Long id) {
        UserAccount u = get(id);
        u.setActive(false);
        repo.save(u);
    }
}
