public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByPermissionKey(String permissionKey);
}
