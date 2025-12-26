public interface UserAccountService {
    UserAccount create(UserAccount user);
    UserAccount get(Long id);
    List<UserAccount> getAll();
    void deactivate(Long id);
}
