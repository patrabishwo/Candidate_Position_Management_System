package com.example.candidate_position_poc.Controller;

import com.example.candidate_position_poc.DTOs.CreateCandidateRequest;
import com.example.candidate_position_poc.DTOs.UpdateCandidateRequest;
import com.example.candidate_position_poc.Entity.Candidate;
import com.example.candidate_position_poc.Service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping
    public ResponseEntity<Candidate> createCandidate(@Valid @RequestBody CreateCandidateRequest request) {
        Candidate savedCandidate = candidateService.createCandidate(request);
        return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Candidate> updateCandidate(
            @PathVariable Long id,
            @Valid @RequestBody UpdateCandidateRequest request
    ) {
        Candidate updatedCandidate = candidateService.updateCandidate(id, request);
        return ResponseEntity.ok(updatedCandidate);
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {
        Candidate candidate = candidateService.getCandidateById(id);
        return ResponseEntity.ok(candidate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidateById(@PathVariable Long id) {
        candidateService.deleteCandidateById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
