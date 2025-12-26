@RestController
@RequestMapping("/api/roles")
@Tag(name = "role-controller")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get role by ID")
    public Role getRole(
        @Parameter(description = "Role ID") @PathVariable Long id
    ) {
        return roleService.getRoleById(id);
    }

    @GetMapping
    @Operation(summary = "Get all roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping
    @Operation(summary = "Create role")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        required = true,
        content = @Content(schema = @Schema(implementation = Role.class))
    )
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update role")
    public Role updateRole(
        @PathVariable Long id,
        @RequestBody Role role
    ) {
        return roleService.updateRole(id, role);
    }

    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate role")
    public void deactivateRole(@PathVariable Long id) {
        roleService.deactivateRole(id);
    }
}
