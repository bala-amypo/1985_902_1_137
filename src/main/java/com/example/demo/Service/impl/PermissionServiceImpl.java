@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repo;

    public PermissionServiceImpl(PermissionRepository repo) {
        this.repo = repo;
    }

    @Override
    public Permission createPermission(Permission permission) {
        if (repo.findByPermissionKey(permission.getPermissionKey()) != null)
            throw new BadRequestException("Permission exists");
        return repo.save(permission);
    }

    @Override
    public Permission updatePermission(Long id, Permission permission) {
        Permission p = getPermissionById(id);
        p.setDescription(permission.getDescription());
        return repo.save(p);
    }

    @Override
    public Permission getPermissionById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found"));
    }

    @Override
    public List<Permission> getAllPermissions() {
        return repo.findAll();
    }

    @Override
    public void deactivatePermission(Long id) {
        Permission p = getPermissionById(id);
        p.setActive(false);
        repo.save(p);
    }
}
