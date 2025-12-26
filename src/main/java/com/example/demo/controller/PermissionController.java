@RestController
@RequestMapping("/api/permissions")
@Tag(name = "permission-controller")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get permission by ID")
    public Permission getPermission(@PathVariable Long id) {
        return permissionService.getPermissionById(id);
    }

    @GetMapping
    @Operation(summary = "Get all permissions")
    public List<Permission> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @PostMapping
    @Operation(summary = "Create permission")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
        required = true,
        content = @Content(schema = @Schema(implementation = Permission.class))
    )
    public Permission createPermission(@RequestBody Permission permission) {
        return permissionService.createPermission(permission);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update permission")
    public Permission updatePermission(
        @PathVariable Long id,
        @RequestBody Permission permission
    ) {
        return permissionService.updatePermission(id, permission);
    }

    @PutMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate permission")
    public void deactivatePermission(@PathVariable Long id) {
        permissionService.deactivatePermission(id);
    }
}
