@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepo;
    private final UserAccountRepository userRepo;
    private final RoleRepository roleRepo;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepo,
                               UserAccountRepository userRepo,
                               RoleRepository roleRepo) {
        this.userRoleRepo = userRoleRepo;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public UserRole assignRole(UserRole mapping) {
        return userRoleRepo.save(mapping);
    }

    @Override
    public List<UserRole> getRolesForUser(Long userId) {
        return userRoleRepo.findByUser_Id(userId);
    }

    @Override
    public UserRole getMappingById(Long id) {
        return userRoleRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mapping not found"));
    }

    @Override
    public void removeRole(Long id) {
        userRoleRepo.deleteById(id);
    }
}
