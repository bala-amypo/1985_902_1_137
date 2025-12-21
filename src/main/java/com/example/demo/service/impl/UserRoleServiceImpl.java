@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository repo;

    public UserRoleServiceImpl(UserRoleRepository repo) {
        this.repo = repo;
    }

    public UserRole assignRole(UserRole userRole) {
        return repo.save(userRole);
    }

    public List<UserRole> getRolesForUser(Long userId) {
        return repo.findAll();
    }

    public UserRole getMappingById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void removeRole(Long id) {
        repo.deleteById(id);
    }
}
