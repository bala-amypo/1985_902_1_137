public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUser_Id(Long userId);
}
