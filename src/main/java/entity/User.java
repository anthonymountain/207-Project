package entity;

/**
 * A simple implementation of the User interface.
 */
public class User {
    private final String id;
    @SuppressWarnings({"checkstyle:MemberName", "checkstyle:SuppressWarnings"})
    private final String display_name;

    /**
     * Creates a user.
     *
     * @param id       the id of the user
     * @param name     the name of the user
     */
    public User(String id, String name) {
        this.display_name = name;
        this.id = id;

    }

    /**
     * Null constructor for User.
     */
    public User() {
        this.display_name = null;
        this.id = null;
    }

    /**
     * Returns the id of the user.
     *
     * @return the id of the user
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the user.
     *
     * @return the name of the user
     */
    public String getName() {
        return display_name;
    }
}
