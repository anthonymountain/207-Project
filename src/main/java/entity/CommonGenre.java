package entity;

/**
 * A simple implementation of the Genre interface.
 */
public class CommonGenre implements Genre {

    private final String type;
    private final String description;

    public CommonGenre(String type, String description) {
        this.type = type;
        this.description = description;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

}
