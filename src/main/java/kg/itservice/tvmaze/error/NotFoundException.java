package kg.itservice.tvmaze.error;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7572575714179705067L;

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
