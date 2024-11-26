package entity;

/**
 * A simple implementation of the User interface.
 */
public class User {
    private final String id;
    @SuppressWarnings({"checkstyle:MemberName", "checkstyle:SuppressWarnings"})
    private final String display_name;

    public User(String id, String name) {
        this.display_name = name;
        this.id = id;
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
