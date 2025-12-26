@RestController
@RequestMapping("/api/role-permissions")
@Tag(name = "role-permission-controller")
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @PostMapping
    @Operation(summary = "Assign permission to role")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        required = true,
        content = @Content(schema = @Schema(implementation = RolePermission.class))
    )
    public RolePermission assignPermission(@RequestBody RolePermission rolePermission) {
        return rolePermissionService.assignPermission(rolePermission);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get role-permission mapping by ID")
    public RolePermission getMapping(@PathVariable Long id) {
        return rolePermissionService.getMappingById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove permission from role")
    public void removePermission(@PathVariable Long id) {
        rolePermissionService.removePermission(id);
    }

    @GetMapping("/role/{roleId}")
    @Operation(summary = "Get permissions for role")
    public List<RolePermission> getPermissionsForRole(@PathVariable Long roleId) {
        return rolePermissionService.getPermissionsForRole(roleId);
    }
}
