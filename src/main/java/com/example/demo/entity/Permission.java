@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String permissionKey;

    private String description;

    private boolean active = true;

    // getters & setters
}
