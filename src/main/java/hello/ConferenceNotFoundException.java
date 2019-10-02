package hello;

public class ConferenceNotFoundException extends Exception {
    private long conference_id;
    public ConferenceNotFoundException(long conference_id) {
        super(String.format("Book is not found with id : '%s'", conference_id));
    }
}
