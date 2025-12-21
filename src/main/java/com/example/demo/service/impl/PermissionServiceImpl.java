@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repo;

    public PermissionServiceImpl(PermissionRepository repo) {
        this.repo = repo;
    }

    public Permission createPermission(Permission permission) {
        return repo.save(permission);
    }

    public Permission updatePermission(Long id, Permission permission) {
        permission.setId(id);
        return repo.save(permission);
    }

    public Permission getPermissionById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Permission> getAllPermissions() {
        return repo.findAll();
    }

    public void deactivatePermission(Long id) {
        repo.findById(id).ifPresent(p -> {
            p.setActive(false);
            repo.save(p);
        });
    }
}
