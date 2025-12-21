@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository repo;

    public RolePermissionServiceImpl(RolePermissionRepository repo) {
        this.repo = repo;
    }

    public RolePermission grantPermission(RolePermission rp) {
        return repo.save(rp);
    }

    public List<RolePermission> getPermissionsForRole(Long roleId) {
        return repo.findAll();
    }

    public RolePermission getMappingById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void revokePermission(Long id) {
        repo.deleteById(id);
    }
}
