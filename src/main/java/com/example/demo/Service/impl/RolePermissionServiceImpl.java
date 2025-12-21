@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository rolePermissionRepo;
    private final RoleRepository roleRepo;
    private final PermissionRepository permissionRepo;

    public RolePermissionServiceImpl(RolePermissionRepository rolePermissionRepo,
                                     RoleRepository roleRepo,
                                     PermissionRepository permissionRepo) {
        this.rolePermissionRepo = rolePermissionRepo;
        this.roleRepo = roleRepo;
        this.permissionRepo = permissionRepo;
    }

    @Override
    public RolePermission grantPermission(RolePermission mapping) {
        return rolePermissionRepo.save(mapping);
    }

    @Override
    public List<RolePermission> getPermissionsForRole(Long roleId) {
        return rolePermissionRepo.findByRole_Id(roleId);
    }

    @Override
    public RolePermission getMappingById(Long id) {
        return rolePermissionRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mapping not found"));
    }

    @Override
    public void revokePermission(Long id) {
        rolePermissionRepo.deleteById(id);
    }
}
