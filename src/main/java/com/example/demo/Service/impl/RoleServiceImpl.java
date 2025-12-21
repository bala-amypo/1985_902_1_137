@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repo;

    public RoleServiceImpl(RoleRepository repo) {
        this.repo = repo;
    }

    @Override
    public Role createRole(Role role) {
        if (repo.findByRoleName(role.getRoleName()) != null)
            throw new BadRequestException("Role exists");
        return repo.save(role);
    }

    @Override
    public Role updateRole(Long id, Role role) {
        Role r = getRoleById(id);
        r.setDescription(role.getDescription());
        return repo.save(r);
    }

    @Override
    public Role getRoleById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
    }

    @Override
    public List<Role> getAllRoles() {
        return repo.findAll();
    }

    @Override
    public void deactivateRole(Long id) {
        Role r = getRoleById(id);
        r.setActive(false);
        repo.save(r);
    }
}
