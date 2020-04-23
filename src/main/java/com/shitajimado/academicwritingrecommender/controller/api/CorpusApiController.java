package com.shitajimado.academicwritingrecommender.controller.api;

import com.shitajimado.academicwritingrecommender.entities.Corpus;
import com.shitajimado.academicwritingrecommender.entities.CorpusRepository;
import com.shitajimado.academicwritingrecommender.entities.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "api", consumes = "application/json", produces = "application/json")
public class CorpusApiController {
    @Autowired private CorpusRepository repository;

    @PostMapping("/create_corpus")
    public void createCorpus(@RequestBody Corpus corpus) {
        //var corpus = new Corpus((String)model.getAttribute("name"), new HashSet<>());
        repository.save(corpus);
    }

    @GetMapping("/read_corpus")
    public List<Corpus> readCorpus() {
        return repository.findAll();
    }

    @PostMapping("/update_corpus")
    public void updateCorpus(Model model) {
        
    }

    @PostMapping("/delete_corpus")
    public void deleteCorpus(Model model) {
        repository.deleteById((String) Objects.requireNonNull(model.getAttribute("id")));
    }
}