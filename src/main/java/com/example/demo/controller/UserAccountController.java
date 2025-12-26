@RestController
@RequestMapping("/users")
@Tag(name = "user-account-controller", description = "User management APIs")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    public UserAccount getUser(
        @Parameter(description = "User ID", required = true)
        @PathVariable Long id
    ) {
        return userAccountService.getUserById(id);
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public List<UserAccount> getAllUsers() {
        return userAccountService.getAllUsers();
    }

    @PostMapping
    @Operation(summary = "Create user")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        required = true,
        content = @Content(schema = @Schema(implementation = UserAccount.class))
    )
    public UserAccount createUser(@RequestBody UserAccount user) {
        return userAccountService.createUser(user);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        required = true,
        content = @Content(schema = @Schema(implementation = UserAccount.class))
    )
    public UserAccount updateUser(
        @Parameter(description = "User ID", required = true)
        @PathVariable Long id,
        @RequestBody UserAccount user
    ) {
        return userAccountService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deactivate user")
    public void deactivateUser(
        @Parameter(description = "User ID", required = true)
        @PathVariable Long id
    ) {
        userAccountService.deactivateUser(id);
    }
}
