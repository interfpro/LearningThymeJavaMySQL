package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MainController {

    @Autowired
    ConferenceRepository conferenceRepository;

    // Get All Notes
    @GetMapping("/conferences")
    public List<Conference> getAllNotes() {
        return conferenceRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/conferences")
    public Conference createNote(@Valid @RequestBody Conference conference) {
        return conferenceRepository.save(conference);
    }

    // Get a Single Note
    @GetMapping("/books/{id}")
    public Conference getNoteById(@PathVariable(value = "id") Long conferenceId) throws ConferenceNotFoundException {
        return conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new ConferenceNotFoundException(conferenceId));
    }

    // Update a Note
    @PutMapping("/books/{id}")
    public Conference updateNote(@PathVariable(value = "id") Long conferenceId,
                           @Valid @RequestBody Conference conferenceDetails) throws ConferenceNotFoundException {

        Conference conference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new ConferenceNotFoundException(conferenceId));

        conference.setName(conferenceDetails.getName());

        Conference updatedConference = conferenceRepository.save(conference);

        return updatedConference;
    }

    // Delete a Note
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long conferenceId) throws ConferenceNotFoundException {
        Conference book = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new ConferenceNotFoundException(conferenceId));

        conferenceRepository.delete(book);

        return ResponseEntity.ok().build();
    }
}