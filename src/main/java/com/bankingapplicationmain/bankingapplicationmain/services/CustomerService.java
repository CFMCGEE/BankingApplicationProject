package com.bankingapplicationmain.bankingapplicationmain.services;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {

        poll = pollRepository.save(poll);

        // Set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getPollId())
                .toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public ResponseEntity<?> updatePoll(@RequestBody Customer customer, @PathVariable Long id) {
        pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
