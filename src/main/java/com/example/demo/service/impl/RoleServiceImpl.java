@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repo;

    public RoleServiceImpl(RoleRepository repo) {
        this.repo = repo;
    }

    public Role createRole(Role role) {
        return repo.save(role);
    }

    public Role updateRole(Long id, Role role) {
        role.setId(id);
        return repo.save(role);
    }

    public Role getRoleById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Role> getAllRoles() {
        return repo.findAll();
    }

    public void deactivateRole(Long id) {
        repo.findById(id).ifPresent(r -> {
            r.setActive(false);
            repo.save(r);
        });
    }
}
